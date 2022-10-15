public class MatrixMultiplication {

    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {

        int[][] returnMatrix = new int[matrix1.length][matrix2[0].length];
        int matrixSum;
        
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrixSum = 0;
                for (int k = 0; k < matrix2.length; k++){
                    matrixSum += matrix1[i][k] * matrix2[k][j];
                }
                returnMatrix[i][j] = matrixSum;
            }
        }

        return returnMatrix;
    }

    public static int[][] parallelMatrixMultiply(int[][] matrix1, int[][] matrix2) {

        int[][] returnMatrix = new int[matrix1.length][matrix2[0].length];
        MatrixRowMultiplier[] returnThreads = new MatrixRowMultiplier[matrix1.length];

        for (int i = 0; i < returnThreads.length; i++) {
            MatrixRowMultiplier someThread = new MatrixRowMultiplier(matrix1[i], matrix2);
            returnThreads[i] = someThread;
            returnThreads[i].start();
        }
        for (int j = 0; j < returnThreads.length; j++) {
            try {
                returnThreads[j].join();
            } catch (InterruptedException e){}
        }
        for (int k = 0; k < returnThreads.length; k++) {
            returnMatrix[k] = returnThreads[k].getResult();
        }

        return returnMatrix;
    }

}
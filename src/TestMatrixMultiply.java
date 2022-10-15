public class TestMatrixMultiply {

    public static void main(String[] args) {
        
        MatrixGenerator thisMatrix = new MatrixGenerator();
        MatrixMultiplication multiply = new MatrixMultiplication();
        
        int[][] matrixArray1 = thisMatrix.generateMatrix(1500, 2400);
        int[][] matrixArray2 = thisMatrix.generateMatrix(2400, 1500);

        long initialTime = System.currentTimeMillis();

        multiply.matrixMultiply(matrixArray1, matrixArray2);
        System.out.println("Time for matrixMultiply is "+Long.toString(System.currentTimeMillis() - initialTime)+"ms");

        initialTime = System.currentTimeMillis();

        multiply.parallelMatrixMultiply(matrixArray1, matrixArray2);
        System.out.println("Time for parallelMatrixMultiply is "+Long.toString(System.currentTimeMillis() - initialTime)+"ms");
    }
}
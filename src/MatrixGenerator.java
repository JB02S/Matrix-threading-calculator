import java.util.Random;

public class MatrixGenerator {

    public static int[][] generateMatrix(int rows, int columns) {

        int[][] returnMatrix = new int[rows][columns];
        Random rand = new Random();
        int randomInt = rand.nextInt(10);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                returnMatrix[i][j] = randomInt;
                randomInt = rand.nextInt(10);
            }
        }

        return returnMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        String returnString = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                returnString = returnString + String.valueOf(matrix[i][j]) + " ";
            }
            System.out.println(returnString);
            returnString = "";
        }
    }


}
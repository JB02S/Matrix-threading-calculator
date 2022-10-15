public class MatrixRowMultiplier extends Thread {

    private int[][] matrix;
    private int[] row;
    private int[] resultRow;

    public MatrixRowMultiplier(int[] row, int[][] matrix) {
        this.row = row;
        this.matrix = matrix;
        this.resultRow = new int[matrix[0].length];
    }

    public void multiplyByRow() {

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < row.length; j++) {
                resultRow[i] += row[j] * matrix[j][i];
            }
        }
    }

    public int[] getResult() {
        return resultRow;
    }

    @Override
    public void run() {
        multiplyByRow();
    }



}
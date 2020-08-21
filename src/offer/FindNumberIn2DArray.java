package offer;

public class FindNumberIn2DArray {


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = matrix[0].length - 1;
        while (row < rows && column >= 0) {
            int number = matrix[row][column];
            if (number == target) {
                return true;
            } else if (number < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }
}

class Solution766 {
    int rows;
    int cols;

    public boolean isToeplitzMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        for (int i = rows - 1; i >= 0; i--) {
            int row = i;
            int col = 0;
            int val = matrix[row][col];
            while (isValid(row, col)) {
                if(val != matrix[row][col]) {
                    return false;
                }
                row = row + 1;
                col = col + 1;
            }
        }

        for (int i = 1; i < cols; i++) {
            int row = 0;
            int col = i;
            int val = matrix[row][col];
            while (isValid(row, col)) {
                if(val != matrix[row][col]) {
                    return false;
                }
                row = row + 1;
                col = col + 1;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}

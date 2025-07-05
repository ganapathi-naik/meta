class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] dir = { { -1, 1 }, { 1, -1 } };
        int[] res = new int[rows * cols];
        int index = 0;
        int currDir = 0;
        int currRow = 0, currCol = 0;
        while(true) {
            if(currDir == 0) { //Going up
                while(currRow >= 0 && currCol < cols) {
                    res[index++] = mat[currRow][currCol];
                    if(currRow == rows - 1 && currCol == cols - 1) {
                        return res;
                    }
                    currRow = currRow + dir[currDir][0];
                    currCol = currCol + dir[currDir][1];
                }
                if(currCol < cols) {
                    currRow = currRow + 1;
                    currCol = currCol + 0;
                } else {
                    currRow = currRow + 2;
                    currCol = currCol - 1;
                }
            } else { //Going down
                while(currRow < rows && currCol >= 0) {
                    res[index++] = mat[currRow][currCol];
                    if(currRow == rows - 1 && currCol == cols - 1) {
                        return res;
                    }
                    currRow = currRow + dir[currDir][0];
                    currCol = currCol + dir[currDir][1];
                }

                if(currRow < rows) {
                    currRow = currRow + 0;
                    currCol = currCol + 1;
                } else {
                    currRow = currRow - 1;
                    currCol = currCol + 2;
                }
            }
            currDir = 1 - currDir;
        }
    }
}
/**
[0, 0], [-1, 1] => Upwards => row - 1, col + 1 => dir = -1
[0, 1], [1, 0], [2, -1] => Downwards => row + 1, col - 1 => dir = dir * (-1) => dir = 1
[2, 0], [1, 1], [0, 2], [-1, 3] => Upwards => row - 1, col + 1 => dir = dir * (-1) => dir = -1
[1, 2], [2, 1], [3, 0] => Downwards => row + 1, col - 1 => dir = dir * (-1) => dir = 1
[2, 2], [1, 3] => Downwards => row + 1, col - 1 => dir = dir * (-1) => dir = -1


 [1, 0]
 [0, 1]

 [2, -1]
 [-1, 2]

 [3, -2]
 [-2, 3]

 */

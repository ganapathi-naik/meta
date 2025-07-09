// Without extra space for visited grid
class Solution200 {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int rows, cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int numberOfIslands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || row > rows - 1 || col < 0 || col > cols - 1 || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        for(int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }
}

// With extra space for visited grid
class Solution200 {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int rows, cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int numberOfIslands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || row > rows - 1 || col < 0 || col > cols - 1 || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        for(int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }
}

class Solution695 {
    int maxAreaOfIsland;
    int rows;
    int cols;
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid, r, c, visited);
                    maxAreaOfIsland = Math.max(area, maxAreaOfIsland);
                }
            }
        }
        return maxAreaOfIsland;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (!isValid(row, col) || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        visited[row][col] = true;
        int res = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            res += dfs(grid, newRow, newCol, visited);
        }
        return res;
    }
}

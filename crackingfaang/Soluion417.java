class Solution417 {
    int rows, cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();
        rows = heights.length;
        cols = heights[0].length;
        for(int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pac, heights[0][c]);
            dfs(heights, rows - 1, c, atl, heights[rows - 1][c]);
        }

        for(int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pac, heights[r][0]);
            dfs(heights, r, cols - 1, atl, heights[r][cols - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(pac.contains(Arrays.asList(r, c)) && atl.contains(Arrays.asList(r, c))) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, Set<List<Integer>> visited, int previousHeight) {
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited.contains(Arrays.asList(row, col)) || heights[row][col] < previousHeight) {
            return;
        }
        visited.add(Arrays.asList(row, col));
        int[][] dirs = new int[][]{{0,1}, {0, -1}, {1,0}, {-1,0}};
        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(heights, newRow, newCol, visited, heights[row][col]);
        }
    }
}

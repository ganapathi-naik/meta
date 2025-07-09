class Solution934 {
    int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
    int rows;
    int cols;

    public int shortestBridge(int[][] grid) {
        Set<List<Integer>> visited = new HashSet<>();
        cols = rows = grid.length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1 && !visited.contains(Arrays.asList(r, c))) {
                    dfs(grid, r, c, visited);
                    return bfs(grid, visited);
                }
            }
        }
        return -1;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    private void dfs(int[][] grid, int r, int c, Set<List<Integer>> visited) {
        if (!isValid(r, c) || grid[r][c] == 0 || visited.contains(Arrays.asList(r, c))) {
            return;
        }
        visited.add(Arrays.asList(r, c));
        for (int[] dir : dirs) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            dfs(grid, newRow, newCol, visited);
        }
    }

    private int bfs(int[][] grid, Set<List<Integer>> visited) {
        int res = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        q.addAll(visited);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                List<Integer> node = q.poll();
                int r = node.get(0);
                int c = node.get(1);
                for (int[] dir : dirs) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    if (isValid(newRow, newCol) && !visited.contains(Arrays.asList(newRow, newCol))) {
                        if (grid[newRow][newCol] == 1) {
                            return res;
                        }
                        q.offer(Arrays.asList(newRow, newCol));
                        visited.add(Arrays.asList(newRow, newCol));
                    }
                }
                size--;
            }
            res += 1;
        }
        return res;
    }
}

/**
 Time and space complexity: O(N^2)
 */

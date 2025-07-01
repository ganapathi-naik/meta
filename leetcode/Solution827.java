class Solution827 {
    Map<Integer, Integer> labelToAreaMap = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        //Precompute the areas of island and store it in hashmap
        int label = 2;
        int maxArea = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, label);
                    labelToAreaMap.put(label, area);
                    maxArea = Math.max(maxArea, area);
                    label++;
                }
            }
        }

        //Run dfs from every grid with val 0
        int largestIsland = maxArea;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    int area = connect(grid, r, c);
                    largestIsland = Math.max(largestIsland, area);
                }
            }
        }
        return largestIsland;
    }

    private int connect(int[][] grid, int r, int c) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int area = 1;
        Set<Integer> visited = new HashSet<>();
        for (int[] dir : dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (!isOutOfBound(grid, row, col) && !visited.contains(grid[row][col])) {
                area += labelToAreaMap.getOrDefault(grid[row][col], 0);
                visited.add(grid[row][col]);
            }
        }
        return area;
    }

    private boolean isOutOfBound(int[][] grid, int r, int c) {
        int n = grid[0].length;
        return r < 0 || r >= n || c < 0 || c >= n;
    }

    int dfs(int[][] grid, int r, int c, int label) {
        if (isOutOfBound(grid, r, c) || grid[r][c] != 1) {
            return 0;
        }
        int size = 1;
        grid[r][c] = label;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] dir : dirs) {
            size += dfs(grid, r + dir[0], c + dir[1], label);
        }
        return size;
    }
}


//Variant

/**
Making A Large Island
You are given ann x m binary matrix grid. You can change as many o's to 1's as long as they do not touch other islands. All 4 directions should be considered.
Return the size of the largest island that can be created in the grid.
An island is a 4-directionally connected group of 1 s.
Example 1:
Input: grid = [ [0, 1,0,1,0], [0,0,0,0, 0], [1,1,1,1,1],
[0,0,0,0,011
Output: 0
Example 2:
Input: grid = [ [0,0,0, 1, 1], [0,0,0,0,0], [0,0,0,0,0], [0,0,0,1,1]]
Output: 10
Constraints:
• n = grid. length
• m = grid [i].length
• 1 <= n, m <= 500
• grid [i]li] is either 0 or 1.
 */
class Solution827 {

    public int largestIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int largestIsland = 0;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 0 && !visited[r][c] && !isTouchingLand(grid, r, c)) {
                    int area = createIsland(grid, r, c, visited);
                    largestIsland = Math.max(area, largestIsland);
                }
            }
        }
        return largestIsland;
    }

    private boolean isOutOfBound(int[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        return r < 0 || r >= rows || c < 0 || c >= cols;
    }

    private boolean isTouchingLand(int[][] grid, int r, int c) {
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] dir : dirs) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];

            if(isOutOfBound(grid, newRow, newCol)) {
                continue;
            }
            if(grid[newRow][newCol] == 1) {
                return true;
            }
        }
        return false;
    }

    private int createIsland(int[][] grid, int r, int c, boolean[][] visited) {
        if(isOutOfBound(grid, r, c) || grid[r][c] != 0 || visited[r][c] || isTouchingLand(grid, r, c)) {
            return 0;
        }
        visited[r][c] = true;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int area = 1;
        for(int[] dir : dirs) {
            area += createIsland(grid, r + dir[0], c + dir[1], visited);
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
        };

        Solution827 solution = new Solution827();
        int result = solution.largestIsland(grid);
        System.out.println("Largest Island Size: " + result);
    }
}

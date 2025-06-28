class Solution1091 {
    public int shortestPathBinaryMatrix(final int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        //bfs using queue
        Queue<Point> q = new LinkedList<>();

        //visited array/set
        Set<Point> visited = new HashSet<>();
        Point startPoint = new Point(0,0);
        q.offer(startPoint);
        visited.add(startPoint);
        int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
                { 1, 1 } };
        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            while (size > 0) {
                Point p = q.poll();
                if (p.row == n - 1 && p.col == n - 1) {
                    return len;
                }
                for (int i = 0; i < 8; i++) {
                    int newRow = p.row + dir[i][0];
                    int newCol = p.col + dir[i][1];
                    if (isValidPoint(grid, newRow, newCol, visited)) {
                        if (newRow == n - 1 && newCol == n - 1) {
                            return len + 1;
                        }
                        Point newP = new Point(newRow, newCol);
                        q.offer(newP);
                        visited.add(newP);
                    }
                }
                size--;
            }
        }
        return -1;
    }

    private boolean isValidPoint(int[][] grid, int row, int col, Set<Point> visited) {
        int n = grid[0].length;
        return (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0 && !visited.contains(new Point(row, col)));
    }
}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Point p = (Point) o;
        return this.row == p.row && this.col == p.col;
    }

    public int hashCode() {
        return Objects.hash(row, col);
    }
}

import java.util.*;

class Solution286 {
    public void wallAndGates(int[][] rooms) {
        int rows = rooms.length, cols = rooms[0].length;
        Queue<List<Integer>> q = new LinkedList<>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(rooms[r][c] == 0) {
                    q.offer(Arrays.asList(r, c, 0));
                }
            }
        }

        if(q.isEmpty()) {
            return;
        }

        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        while(!q.isEmpty()) {
            List<Integer> node = q.poll();
            int row = node.get(0);
            int col = node.get(1);
            int distance = node.get(2);

            if(distance <= rooms[row][col]) {
                for(int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        q.offer(Arrays.asList(newRow, newCol, distance + 1));
                    }
                }
            }
        }
    }
}

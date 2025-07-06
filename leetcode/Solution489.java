class Solution489 {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // clockwise movement
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0, 0);
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private void dfs(Robot robot, Set<String> visited, int row, int col, int direction) {
        visited.add(row + "," + col);
        robot.clean();

        for(int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;

            int newRow = row + dir[newDirection][0];
            int newCol = col + dir[newDirection][1];

            if(!visited.contains(newRow + "," + newCol) && robot.move()) {
                dfs(robot, visited, newRow, newCol, newDirection);
                goBack(robot);
            }
            robot.turnRight();
        }
    }
}

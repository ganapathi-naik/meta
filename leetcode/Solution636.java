class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] executionTimes = new int[n];
        Stack<Integer> stack = new Stack<>();
        int previousTimestamp = 0;
        for(String log : logs) {
            String[] logLine = log.split(":");

            int functionId = Integer.valueOf(logLine[0]);
            String type = logLine[1];
            int currentTimestamp = Integer.valueOf(logLine[2]);

            if(type.equals("start")) {
                if(!stack.isEmpty()) {
                    executionTimes[stack.peek()] += currentTimestamp - previousTimestamp;
                }
                stack.push(functionId);
                previousTimestamp = currentTimestamp;
            } else { // type == end
                executionTimes[stack.pop()] += (currentTimestamp - previousTimestamp + 1);
                previousTimestamp = currentTimestamp + 1;
            }
        }
        return executionTimes;
    }
}

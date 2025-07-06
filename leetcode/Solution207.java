class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topologicalSorting = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                topologicalSorting.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    q.offer(neighbour);
                    topologicalSorting.add(neighbour);
                }
            }
        }
        return topologicalSorting.size() == numCourses;
    }
}

import java.util.*;
class Solution1136 {
    public int minimumSemester(int n, int[][] relations) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[n];
        for(int[] relation : relations) {
            int src = relation[0] - 1;
            int dst = relation[1] - 1;
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dst);
            indegree[dst] += 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        int ans = 0;
        int numberOfCoursesTook = 0;
        while(!q.isEmpty()) {
            ans += 1;
            int size = q.size();
            while(size > 0) {
                int node = q.poll();
                numberOfCoursesTook += 1;
                for(int neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
                    indegree[neighbour] -= 1;
                    if(indegree[neighbour] == 0) {
                        q.offer(indegree[neighbour]);
                    }
                }
                size--;
            }
        }

        return numberOfCoursesTook == n ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1136().minimumSemester(3, new int[][]{{1,3}, {2,3}}));
        System.out.println(new Solution1136().minimumSemester(3, new int[][]{{1,3}, {2,3}, {3,1}}));
    }
}

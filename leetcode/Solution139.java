class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s == "") {
            return false;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(s);
        visited.add(s);

        while(!q.isEmpty()) {
            String str = q.poll();
            if(str == "") {
                return true;
            }
            for(String word : wordDict) {
                if(str.startsWith(word)) {
                    String splitWord = str.substring(word.length());
                    if(!visited.contains(splitWord)) {
                        q.offer(splitWord);
                        visited.add(splitWord);
                    }
                }
            }
        }

        return false;
    }
}

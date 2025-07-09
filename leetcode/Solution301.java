class Solution301 {
    int longestStringLength = -1;
    Set<String> res = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, sb, 0, 0);
        return new ArrayList<>(res);
    }

    private void dfs(String s, int currIndex, StringBuilder sb, int open, int close) {
        if(currIndex >= s.length()) {
            if(open == close) {
                if(sb.length() > longestStringLength) {
                    longestStringLength = sb.length();
                    res = new HashSet<>();
                    res.add(sb.toString());
                } else if(sb.length() == longestStringLength) {
                    res.add(sb.toString());
                }
            }
            return;
        }

        char c = s.charAt(currIndex);
        if(c == '(') {
            sb.append(c);
            dfs(s, currIndex + 1, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);

            dfs(s, currIndex + 1, sb, open, close);
        } else if(c == ')') {
            dfs(s, currIndex + 1, sb, open, close);
            if(open > close) {
                sb.append(c);
                dfs(s, currIndex + 1, sb, open, close + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(c);
            dfs(s, currIndex + 1, sb, open, close);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

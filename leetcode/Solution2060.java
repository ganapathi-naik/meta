class Solution2060 {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean possiblyEquals(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        int diff = 0;
        return dfs(s1, index1, s2, index2, diff);
    }

    private boolean dfs(String s1, int index1, String s2, int index2, int diff) {
        String key = index1 + ":" + index2 + ":" + diff;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index1 == s1.length() && index2 == s2.length()) {
            boolean res = diff == 0;
            memo.put(key, res);
            return res;
        }

        if (index1 == s1.length() && diff < 0) {
            memo.put(key, false);
            return false;
        }

        if (index2 == s2.length() && diff > 0) {
            memo.put(key, false);
            return false;
        }

        int num1 = 0;
        for (int i = index1; i < s1.length() && Character.isDigit(s1.charAt(i)); i++) {
            num1 = num1 * 10 + (s1.charAt(i) - '0');
            if (dfs(s1, i + 1, s2, index2, diff + num1)) {
                memo.put(key, true);
                return true;
            }
        }

        int num2 = 0;
        for (int i = index2; i < s2.length() && Character.isDigit(s2.charAt(i)); i++) {
            num2 = num2 * 10 + (s2.charAt(i) - '0');
            if (dfs(s1, index1, s2, i + 1, diff - num2)) {
                memo.put(key, true);
                return true;
            }
        }

        if (diff < 0 && index1 < s1.length() && !Character.isDigit(s1.charAt(index1))) {
            boolean res = dfs(s1, index1 + 1, s2, index2, diff + 1);
            memo.put(key, res);
            return res;
        }

        if (diff > 0 && index2 < s2.length() && !Character.isDigit(s2.charAt(index2))) {
            boolean res = dfs(s1, index1, s2, index2 + 1, diff - 1);
            memo.put(key, res);
            return res;
        }

        if (diff == 0 && index1 < s1.length() && index2 < s2.length() && !Character.isDigit(s1.charAt(index1)) && !Character.isDigit(s2.charAt(index2))) {
            boolean res = s1.charAt(index1) == s2.charAt(index2) && dfs(s1, index1 + 1, s2, index2 + 1, 0);
            memo.put(key, res);
            return res;
        }

        memo.put(key, false);
        return false;
    }
}

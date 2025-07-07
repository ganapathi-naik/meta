class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")) {
            return 0;
        }
        Set<Character> elementsSeen = new HashSet<>();
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        while(right < s.length()) {
            while(elementsSeen.contains(s.charAt(right))) {
                elementsSeen.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
            elementsSeen.add(s.charAt(right));
            right++;
        }
        return res;
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}

class Solution680 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isSubstringValidPalindrome(s.substring(left, right))
                        || isSubstringValidPalindrome(s.substring(left + 1, right + 1));
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isSubstringValidPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class Solution125 {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (!isAlphanumeric(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isAlphanumeric(s.charAt(r))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}

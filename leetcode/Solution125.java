class Solution125 {
    public boolean isPalindrome(String s) {
        String sLower = s.toLowerCase();
        int l = 0, r = sLower.length() - 1;

        while (l < r) {
            if (!isAlphanumeric(sLower.charAt(l))) {
                l++;
                continue;
            }
            if (!isAlphanumeric(sLower.charAt(r))) {
                r--;
                continue;
            }
            if (sLower.charAt(l) != sLower.charAt(r)) {
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

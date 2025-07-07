class Solution8 {
    public int myAtoi(String s) {
        long res = 0;
        boolean gotSign = false;
        boolean gotDigit = false;
        boolean isNegative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !gotSign && !gotDigit) {
                continue;
            } else if (!gotDigit && !gotSign && c == '+') {
                gotSign = true;
                continue;
            } else if (!gotDigit && !gotSign && c == '-') {
                gotSign = true;
                isNegative = true;
                continue;
            } else if (Character.isDigit(c)) {
                gotDigit = true;
                res = res * 10 + (c - '0');
                if(res > Integer.MAX_VALUE) {
                    break;
                }
            } else {
                break;
            }
        }

        if (isNegative) {
            res = res * -1;
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) res;
    }
}

// Without using long
class Solution8 {
    public int myAtoi(String s) {
        int res = 0;
        boolean gotSign = false;
        boolean gotDigit = false;
        boolean isNegative = false;
        int threshold = Integer.MAX_VALUE / 10;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !gotSign && !gotDigit) {
                continue;
            } else if (!gotDigit && !gotSign && c == '+') {
                gotSign = true;
                continue;
            } else if (!gotDigit && !gotSign && c == '-') {
                gotSign = true;
                isNegative = true;
                continue;
            } else if (Character.isDigit(c)) {
                gotDigit = true;
                // -2147483648
                //  2147483647
                if(res > threshold || (res == threshold && (c - '0') > 7)) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + (c - '0');
            } else {
                break;
            }
        }
        return isNegative ? -1 * res : res;
    }
}

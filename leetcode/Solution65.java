class Solution65 {
    public boolean isNumber(String s) {
        boolean numberSeen = false, decimalUsed = false;
        int index = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }

        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isAlphabetic(c)) {
                if (c == 'e' || c == 'E') {
                    if (numberSeen && isValidNumber(s.substring(index + 1))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (c == '.') {
                if (decimalUsed) {
                    return false;
                } else {
                    decimalUsed = true;
                }
            } else if (c == '+' || c == '-') {
                return false;
            } else {
                numberSeen = true;
            }
            index++;
        }
        return numberSeen;
    }

    private boolean isValidNumber(String stringToTest) {
        if (stringToTest == "") {
            return false;
        }
        boolean numberSeen = false;
        int index = 0;
        if (stringToTest.charAt(index) == '+' || stringToTest.charAt(index) == '-') {
            index++;
        }

        while (index < stringToTest.length()) {
            char c = stringToTest.charAt(index);
            if (!Character.isDigit(c)) {
                return false;
            } else {
                numberSeen = true;
            }
            index++;
        }
        return numberSeen;
    }
}

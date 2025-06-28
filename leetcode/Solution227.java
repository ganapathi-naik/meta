class Solution227 {
    public int calculate(String s) {
        char operator = '+';
        int lastNumber = 0, currentNumber = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                currentNumber = (currentNumber * 10) + (s.charAt(i) - '0');
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == (s.length() - 1)) {
                if (operator == '+') {
                    res += lastNumber;
                    lastNumber = currentNumber;
                } else if (operator == '-') {
                    res += lastNumber;
                    lastNumber = currentNumber * (-1);
                } else if (operator == '*') {
                    lastNumber = (lastNumber * currentNumber);
                } else if (operator == '/') {
                    lastNumber = (lastNumber / currentNumber);
                }
                operator = s.charAt(i);
                currentNumber = 0;
            }
        }
        return res + lastNumber;
    }
}

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int currIndex = 0;
        while (currIndex < s.length()) {
            char c = s.charAt(currIndex);
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
            currIndex++;
        }
        return stack.isEmpty();
    }
}

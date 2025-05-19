class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        int open = 0, close = 0;
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(c == '(') {
                open++;
            } else if (c == ')') {
                if(close == open) {
                    continue;
                }
                close++;
            }
            sb.append(c);
        }
        if(open == close) {
            return sb.toString();
        }

        open = close = 0;
        charArray = sb.toString().toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            if(c == ')') {
                close++;
            } else if (c == '(') {
                if(close == open) {
                    continue;
                }
                open++;
            }
            res.append(c);
        }
        return res.reverse().toString();
    }
}

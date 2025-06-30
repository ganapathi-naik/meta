class Solution921 {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        int minNeeded = 0;
        for(int c : s.toCharArray()) {
            if(c == '(') {
                open++;
            } else {
                close++;
                if(close > open) {
                    open++;
                    minNeeded++;
                }
            }
        }
        minNeeded += (open - close);
        return minNeeded;
    }
}

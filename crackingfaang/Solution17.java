class Solution17 {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")) {
            return res;
        }
        Map<Character, String> digitToStrs = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
        );

        String[] strs = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++) {
            strs[i] = digitToStrs.get(digits.charAt(i));
        }
        letterCombinations(strs, 0, "");
        return res;
    }

    private void letterCombinations(String[] strs, int index, String localRes) {
        if(index == strs.length) {
            res.add(localRes);
            return;
        }

        for(int i = 0; i < strs[index].length(); i++) {
            letterCombinations(strs, index + 1, localRes + strs[index].charAt(i));
        }
    }
}

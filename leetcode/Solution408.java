public class Solution408 {

    public static boolean validWordAbbreviation(String word, String abbr) {
        int w = 0, a = 0;
        char[] wArray = word.toCharArray();
        char[] aArray = abbr.toCharArray();
        while(w < word.length() && a < abbr.length()) {
            if(Character.isDigit(aArray[a])) {
                int value = 0;
                while(a < abbr.length() && Character.isDigit(aArray[a])) {
                    value = (value * 10) + (aArray[a] - '0');
                    a++;
                }
                w += value;
            } else {
                if(wArray[w] != aArray[a]) {
                    return false;
                }
                a++;
                w++;
            }
        }
        return (w == word.length() && a == abbr.length());
    }
}

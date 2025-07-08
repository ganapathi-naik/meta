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

public class Solution408 {

    public static boolean validWordAbbreviation(String word, String abbr) {
        int w = 0, a = 0;

        while (w < word.length() && a < abbr.length()) {
            char abbrChar = abbr.charAt(a);

            if (Character.isDigit(abbrChar)) {
                // Leading zero is not allowed
                if (abbrChar == '0') return false;

                int value = 0;
                while (a < abbr.length() && Character.isDigit(abbr.charAt(a))) {
                    value = (value * 10) + (abbr.charAt(a) - '0');
                    a++;
                }
                w += value;
            } else {
                if (w >= word.length() || word.charAt(w) != abbrChar) {
                    return false;
                }
                w++;
                a++;
            }
        }

        return (w == word.length() && a == abbr.length());
    }
}

/**
Time Complexity: O(m)
Where:
m = length of the abbr

Why?
Each character in abbr is visited at most once by the pointer a.

In the worst case:
You parse through a sequence of digits (e.g., "123" → 3 digits → 1 number).
Each letter or digit is processed in constant time.
Even if the pointer w moves forward by a large number, we're not iterating over those characters, we're just skipping ahead.
So, total time = O(m)

Space Complexity: O(1)

Why?
No additional data structures are used.
Variables like w, a, and value take constant space.
No char[] arrays are created anymore.
So, space = O(1) (constant space)
 */

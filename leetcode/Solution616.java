import java.util.*;
class Solution616 {
    public String addBoldTag(String s, String[] words) {
        boolean[] boldTags = new boolean[s.length()];
        for(String word : words) {
            int start = s.indexOf(word);
            int length = word.length();
            while(start != -1) {
                for(int i = start; i < start + length; i++) {
                    boldTags[i] = true;
                }
                start = s.indexOf(word, start + 1);
            }
        }
        StringBuilder res = new StringBuilder();
        int index = 0;
        while(index < s.length()) {
            if(boldTags[index]) {
                res.append("<br>");
                while(index < s.length() && boldTags[index]) {
                    res.append(s.charAt(index));
                    index++;
                }
                res.append("</br>");
            } else {
                res.append(s.charAt(index));
                index++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution616 solution616 = new Solution616();
        System.out.println(solution616.addBoldTag("abcxyz123", new String[]{"abc","123"}));
        System.out.println(solution616.addBoldTag("aaaxbbb", new String[]{"aa","b"}));
        System.out.println(solution616.addBoldTag("aaabbcc", new String[]{"aaa","aab","bc"}));
    }
}

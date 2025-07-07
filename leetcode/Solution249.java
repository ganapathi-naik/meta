import java.util.*;
class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> sequenceToStringMap = new HashMap<>();
        for(String string : strings) {
            StringBuilder sb = new StringBuilder();
            if(string.length() == 1) {
                sb.append("-1,");
            } else {
                String prefix = "";
                for(int i = 1; i < string.length(); i++) {
                    sb.append(prefix).append(((string.charAt(i) - string.charAt(i - 1)) + 26) % 26);
                    prefix = ",";
                }
            }
            sequenceToStringMap.putIfAbsent(sb.toString(), new ArrayList<>());
            sequenceToStringMap.get(sb.toString()).add(string);
        }
        return new ArrayList<>(sequenceToStringMap.values());
    }

    public static void main(String[] args) {
        System.out.println(new Solution249().groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}

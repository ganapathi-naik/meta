class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            for(char c : str.toCharArray()) {
                count[c - 'a'] += 1;
            }
            String key = Arrays.toString(count);
            anagrams.putIfAbsent(key, new ArrayList<>());
            anagrams.get(key).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}
/**
 * Time Complexity: O(N * M) => N is length of strs and M is average length of each string.
 * Space Complexity: O(N) => N is length of strs
 */

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            anagrams.putIfAbsent(sortedStr, new ArrayList<>());
            anagrams.get(sortedStr).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}

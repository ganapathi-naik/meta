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

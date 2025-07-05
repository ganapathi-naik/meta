class Solution {
    public String customSortString(String order, String s) {
        String res = "";
        Map<Character, Integer> charToFrequencyMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            charToFrequencyMap.put(c, charToFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for(char c : order.toCharArray()) {
            int frequency = charToFrequencyMap.getOrDefault(c, 0);
            for(int i = 0; i < frequency; i++) {
                res += c;
            }
            charToFrequencyMap.remove(c);
        }

        for(Map.Entry<Character, Integer> entry : charToFrequencyMap.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            for(int i = 0; i < frequency; i++) {
                res += c;
            }
        }
        return res;
    }
}

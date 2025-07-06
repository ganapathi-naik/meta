class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int frequency = tMap.getOrDefault(c, 0);
            tMap.put(c, frequency + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int need = tMap.size(), have = 0;
        int left = 0;
        int maxLength = Integer.MAX_VALUE;
        int[] subStringIndex = new int[2];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);

                if (sMap.getOrDefault(c, 0).intValue() == tMap.getOrDefault(c, 0).intValue()) {
                    have++;
                }
            }
            while (have == need) {
                if (maxLength > (right - left + 1)) {
                    maxLength = (right - left + 1);
                    subStringIndex = new int[]{left, right + 1};
                }
                char leftIndexVal = s.charAt(left);
                if(sMap.containsKey(leftIndexVal)) {
                    sMap.put(leftIndexVal, sMap.getOrDefault(leftIndexVal, 0) - 1);
                    if(sMap.getOrDefault(leftIndexVal, 0) < tMap.getOrDefault(leftIndexVal, 0)) {
                        have--;
                    }
                }
                left++;
            }
        }
        return s.substring(subStringIndex[0], subStringIndex[1]);
    }
}

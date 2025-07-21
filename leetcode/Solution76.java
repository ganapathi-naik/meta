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
        int minLength = Integer.MAX_VALUE;
        int[] subStringIndex = new int[2];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);

                if (sMap.get(c).intValue() == tMap.get(c).intValue()) {
                    have++;
                }
            }
            while (have == need) {
                if (minLength > (right - left + 1)) {
                    minLength = (right - left + 1);
                    subStringIndex = new int[]{left, right + 1};
                }
                char leftIndexVal = s.charAt(left);
                if(sMap.containsKey(leftIndexVal)) {
                    sMap.put(leftIndexVal, sMap.get(leftIndexVal) - 1);
                    if(sMap.get(leftIndexVal) < tMap.get(leftIndexVal)) {
                        have--;
                    }
                }
                left++;
            }
        }
        return s.substring(subStringIndex[0], subStringIndex[1]);
    }
}

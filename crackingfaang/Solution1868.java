class Solution1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();

        int i = 0, j = 0;
        while(i < encoded1.length && j < encoded2.length) {
            int v1 = encoded1[i][0];
            int f1 = encoded1[i][1];

            int v2 = encoded2[i][0];
            int f2 = encoded2[i][1];

            int res = v1 * v2;
            int frequency = Math.min(f1, f2);
            int lastIndex = res.size() - 1;

            if(res.size() > 0 && res.get(lastIndex).get(0) == res) {
                int newFrequency = frequency + res.get(lastIndex).get(1);
                res.set(lastIndex, Arrays.asList(res, frequency + res.get(lastIndex).get(1)));
            } else {
                res.add(Arrays.asList(res, frequency));
            }
            encoded1[i][1] = encoded1[i][1] - frequency;
            encoded1[j][1] = encoded1[j][1] - frequency;

            if(f1 == frequency) {
                i++;
            }

            if(f2 == frequency) {
                j++;
            }
        }
        return res;
    }
}

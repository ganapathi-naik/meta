class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fPtr = 0, sPtr = 0;
        List<int[]> res = new ArrayList<>();
        while (fPtr < firstList.length && sPtr < secondList.length) {
            if (firstList[fPtr][0] <= secondList[sPtr][1] && firstList[fPtr][1] >= secondList[sPtr][0]) {
                int index1 = Math.max(firstList[fPtr][0], secondList[sPtr][0]);
                int index2 = Math.min(firstList[fPtr][1], secondList[sPtr][1]);
                res.add(new int[] { index1, index2 });
            }
            if (firstList[fPtr][1] > secondList[sPtr][1]) {
                sPtr++;
            } else {
                fPtr++;
            }
        }
        return res.toArray(new int[0][]);
    }
}

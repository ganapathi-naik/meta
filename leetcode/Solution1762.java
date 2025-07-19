class Solution1762 {
    public int[] findBuildings(int[] heights) {
        int len = heights.length;
        int maxHeightToRight = Integer.MIN_VALUE;
        List<Integer> building = new ArrayList<>();
        for(int i = len - 1; i >= 0; i++) {
            if(heights[i] > maxHeightToRight) {
                building.add(0, i);
                maxHeightToRight = heights[i];
            }
        }
        Collections.reverse(building);
        return building.stream().mapToInt(Integer::intValue).toArray();
    }
}

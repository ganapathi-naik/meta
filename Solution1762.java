class Solution1762 {
    public int[] findBuildings(int[] heights) {
        int len = heights.length;
        int maxHeightToRight = 0;
        List<Integer> building = new ArrayList<>();
        for(int i = len - 1; i >= 0; i++) {
            if(heights[i] > maxHeightToRight) {
                building.add(i);
                maxHeightToRight = heights[i];
            }
        }
        Collections.reverse(building);
        return building.toArray(new int[0]);
    }
}

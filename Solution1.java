class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    //optimised solution
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> requiredNumToIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(requiredNumToIndexMap.containsKey(target - nums[i])) {
                return new int[] {requiredNumToIndexMap.get(target - nums[i]), i};
            }
            requiredNumToIndexMap.put(nums[i], i);
        }
        return new int[2];
    }
}

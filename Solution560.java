class Solution560 {
    // // Brute force approach
    // public int subarraySum(int[] nums, int target) {
    //     int totalSubArrays = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i; j < nums.length; j++) {
    //             int[] sArray = new int[j - i + 1];
    //             int index = 0;
    //             int sum = 0;
    //             for (int k = i; k <= j; k++) {
    //                 sArray[index++] = nums[k];
    //                 sum += nums[k];
    //             }
    //             if (sum == target) {
    //                 totalSubArrays++;
    //             }
    //         }
    //     }
    //     return totalSubArrays;
    // }

    // Optimised approach
    public int subarraySum(int[] nums, int k) {
        int totalSubArrays = 0;
        Map<Integer, Integer> prefixSumToFrequency = new HashMap<>();
        prefixSumToFrequency.put(0, 1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSumToFrequency.containsKey(prefixSum - k)) {
                totalSubArrays += prefixSumToFrequency.get(prefixSum - k);
            }
            int count = prefixSumToFrequency.getOrDefault(prefixSum, 0);
            prefixSumToFrequency.put(prefixSum, count + 1);
        }
        return totalSubArrays;
    }
}

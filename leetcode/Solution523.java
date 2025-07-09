class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> reminderToIndexMap = new HashMap<>();
        reminderToIndexMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (!reminderToIndexMap.containsKey(reminder)) {
                reminderToIndexMap.put(reminder, i);
            } else if(i - reminderToIndexMap.get(reminder) > 1) {
                return true;
            }
        }
        return false;
    }
}

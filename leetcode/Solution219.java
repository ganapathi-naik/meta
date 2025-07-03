
//Optimised Time complexity: O(N) and space complexity: O(K)
class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            if(r - l > k) {
                window.remove(nums[l]);
                l++;
            }
            if(window.contains(nums[r])) {
                return true;
            }
            window.add(nums[r]);
        }
        return false;
    }
}

//Optimised Time complexity: O(N) and space complexity: O(N)
class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numbersSeen = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(numbersSeen.containsKey(nums[i]) && (int)Math.abs(numbersSeen.get(nums[i]) - i) <= k) {
                return true;
            }
            numbersSeen.put(nums[i], i);
        }
        return false;
    }
}

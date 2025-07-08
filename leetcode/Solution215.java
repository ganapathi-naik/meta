class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.poll();
    }
}
/**
Time Complexity:
Inserting first k elements into the heap:

Each offer operation takes O(log k) time.
Total for first k elements: O(k log k)
Processing the remaining n - k elements:
Each comparison is O(1), and possibly one poll() + one offer() = O(log k).
In worst case, every element causes a heap update: O((n - k) log k)

Total time = O(k log k + (n - k) log k) = O(n log k)

Space Complexity:
The heap stores at most k elements → O(k) space.

✅ Final Answer:
Time Complexity: O(n log k)
Space Complexity: O(k)
 */

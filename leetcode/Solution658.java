class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            int d1 = Math.abs(b - x) - Math.abs(a - x);
            if (d1 != 0) {
                return d1;
            }
            return b - a;
        );

        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(maxHeap);
        Collections.sort(result);
        return result;
    }
}
/**
Time Complexity: O(log(n - k) + k)
Space Complexity: O(k)
*/

class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

/**
Time Complexity
Each insertion and removal in the heap: O(log k)
For n elements: O(n log k)
Final sort: O(k log k)
Total Time Complexity: O(n log k)
*/

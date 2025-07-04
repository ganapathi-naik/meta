class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> elementsToRemove = new HashMap<>();
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() > nums[i]) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            // balancing heaps(maxHeap size will atmost 1 + size of minHeap)
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else if (minHeap.size() + 1 < maxHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        double median;

        if (k % 2 == 0) {
            median = minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
            res[0] = median;
        } else {
            median = maxHeap.peek();
            res[0] = median;
        }

        for (int i = k; i < nums.length; i++) {
            int prevElement = nums[i - k];
            elementsToRemove.put(prevElement, elementsToRemove.getOrDefault(prevElement, 0) + 1);
            int balance = prevElement <= median ? -1 : 1;

            if (nums[i] <= median) {
                balance++;
                maxHeap.offer(nums[i]);
            } else {
                balance--;
                minHeap.offer(nums[i]);
            }

            if (balance < 0) {
                maxHeap.offer(minHeap.poll());
            } else if (balance > 0) {
                minHeap.offer(maxHeap.poll());
            }

            while (!maxHeap.isEmpty() && elementsToRemove.getOrDefault(maxHeap.peek(), 0) > 0) {
                elementsToRemove.put(maxHeap.peek(), elementsToRemove.get(maxHeap.peek()) - 1);
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && elementsToRemove.getOrDefault(minHeap.peek(), 0) > 0) {
                elementsToRemove.put(minHeap.peek(), elementsToRemove.get(minHeap.peek()) - 1);
                minHeap.poll();
            }

            if (k % 2 == 0) {
                median = minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
                res[i-k+1] = median;
            } else {
                median = maxHeap.peek();
                res[i-k+1] = median;
            }
        }
        return res;
    }
}

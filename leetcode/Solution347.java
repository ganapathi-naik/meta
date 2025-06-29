class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
        for(int num : nums) {
            int frequency = numToFrequencyMap.getOrDefault(num, 0);
            numToFrequencyMap.put(num, frequency + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.frequency - n2.frequency);
        List<Integer> keys = new ArrayList<>(numToFrequencyMap.keySet());
        for(int i = 0; i < k; i++) {
            int key = keys.get(i);
            int frequency = numToFrequencyMap.get(key);
            pq.offer(new Node(key, frequency));
        }

        for(int i = k; i < keys.size(); i++) {
            int key = keys.get(i);
            int frequency = numToFrequencyMap.get(key);
            if(pq.peek().frequency < frequency) {
                pq.poll();
                pq.offer(new Node(key, frequency));
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!pq.isEmpty()) {
            res[index++] = pq.poll().val;
        }
        return res;
    }
}

class Node {
    int val;
    int frequency;

    public Node(int val, int frequency) {
        this.val = val;
        this.frequency = frequency;
    }
}

class Solution767 {
    public String reorganizeString(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.frequency - n1.frequency);
        Map<Character, Integer> map = new HashMap<>();
        for(char c :  s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        Node prevNode = null;
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            Node currNode = pq.poll();
            sb.append(currNode.val);
            currNode.frequency = currNode.frequency - 1;

            if(prevNode != null) {
                pq.offer(new Node(prevNode.val, prevNode.frequency));
            }

            if(currNode.frequency > 0) {
                prevNode = currNode;
            } else {
                prevNode = null;
            }
        }

        if(prevNode != null && prevNode.frequency > 0) {
            return "";
        }
        return sb.toString();
    }
}

class Node {
    char val;
    int frequency;

    public Node(char val, int frequency) {
        this.frequency = frequency;
        this.val = val;
    }

    public String toString() {
        return "" + val + ":" + frequency;
    }
}

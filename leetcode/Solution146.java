class Solution146 {
/**
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.
 */
}
class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> keyNodeMap;
    int capacity;
    int currentCapacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.keyNodeMap = new HashMap<>();
    }

    private void addFirst(Node newNode) {
        this.head.next.prev = newNode;
        newNode.next = this.head.next;
        newNode.prev = head;
        head.next = newNode;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyNodeMap.get(key);
        remove(node);
        addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            remove(node);
            addFirst(node);
            node.val = value;
            return;
        }

        if (this.currentCapacity == this.capacity) {
            keyNodeMap.remove(tail.prev.key);
            remove(tail.prev);
            currentCapacity--;
        }

        if (this.currentCapacity < this.capacity) {
            Node newNode = new Node(key, value);
            addFirst(newNode);
            keyNodeMap.put(key, newNode);
            currentCapacity++;
        }
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

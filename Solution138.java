/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldNodeToNewNodeMapping = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            oldNodeToNewNodeMapping.putIfAbsent(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        Node newCurrNode = null;
        while(curr != null) {
            newCurrNode = oldNodeToNewNodeMapping.get(curr);
            newCurrNode.random = oldNodeToNewNodeMapping.get(curr.random);
            newCurrNode.next = oldNodeToNewNodeMapping.get(curr.next);
            curr = curr.next;
            newCurrNode = newCurrNode.next;
        }
        return oldNodeToNewNodeMapping.get(head);
    }
}

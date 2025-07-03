class Solution708 {
    Node insert(Node head, int targetValue) {
        Node newNode = new Node(targetValue);
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head.next, prev = head;
        if(curr == prev) {
            head.next = newNode;
            newNode.next = head;
            return head;
        }

        while(true) {
            if(curr.val >= targetValue && prev.val <= targetValue) {
                break;
            }

            if(prev.val > curr.val) {
                if(targetValue >= prev.val || targetValue <= curr.val) {
                    break;
                }
            }
            prev = curr;
            curr = curr.next;

            if (prev == head) {
                break;
            }
        }
        prev.next = newNode;
        newNode.next = curr;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        if(nodes.size() == 1) {
            return null;
        }
        int targetIndex = nodes.size() - n;

        if(targetIndex == 0) {
            return nodes.get(targetIndex).next;
        }
        ListNode prev = nodes.get(targetIndex - 1);
        ListNode next = nodes.get(targetIndex).next;
        prev.next = next;

        return head;
    }
}


class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        int index = 0;
        while(curr != null && index < n) {
            curr = curr.next;
            index++;
        }

        while(curr != null) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}

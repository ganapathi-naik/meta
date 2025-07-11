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
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), curr = head;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(reminder);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = l1.val + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(reminder);
            curr = curr.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + carry;
            int reminder = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(reminder);
            curr = curr.next;
            l2 = l2.next;
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}

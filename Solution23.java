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
class Solution21 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n < 1) {
            return null;
        }
        return mergeLists(lists, 0, n - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if(right == left) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid + 1, right);
        return mergeSortedLists(leftList, rightList);
    }

    private ListNode mergeSortedLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), curr = head;
        ListNode h1 = list1, h2 = list2;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }

        if (h1 != null) {
            curr.next = h1;
        }

        if (h2 != null) {
            curr.next = h2;
        }
        return head.next;
    }
}

//Using PriorityQueue
class Solution21 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        int k = lists.length;
        for(int i = 0; i < k; i++) {
            if(lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode head = new ListNode(), curr = head;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null) {
                pq.offer(node.next);
            }
        }
        return head.next;
    }
}

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
class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode temp = right.next;
        right.next = null;
        right = temp;
        ListNode list1 = sortList(left);
        ListNode list2 = sortList(right);
        return sort(list1, list2);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode sort(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), curr = dummy;
        while(list1 != null & list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null) {
            curr.next = list1;
        }
        if(list2 != null) {
            curr.next = list2;
        }
        return dummy.next;
    }
}

/**
Time complexity: O(N) * O(logN) => O(N): For merging 2 arrays and O(logN): For splitting
Space complexity: O(logN)

✅ Time Complexity: O(n log n)
The sortList method recursively divides the list into halves, similar to how Merge Sort works.

Each level of recursion splits the list into two halves → log₂n levels.

At each level, all n nodes are processed during the merge step (sort() method).

🔁 So overall:

Divide step (log n levels)

Merge step (each level merges n nodes)

Total = O(n log n)

✅ Space Complexity: O(log n)
Since you are using recursion, each recursive call adds a frame to the call stack.

In the worst case, the recursion depth is log n (due to the divide step).

No extra space is used apart from the recursion stack and a few pointers.

💡 Important:
This is better than array-based merge sort (which uses O(n) space) — linked list merge sort can be done in-place using pointer manipulation.
 */

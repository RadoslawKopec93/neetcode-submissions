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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        if (head.next == null && n == 1) {
            return null;
        }

        ListNode r = revert(head);
        ListNode curr = r;
        ListNode p = null;
        int i = 1;
        while (i < n && curr.next != null) {
            i++;
            p = curr;
            curr = curr.next;
        }

        if (p == null) {
            return revert(curr.next);
        }
        p.next = curr.next;

        return revert(r);
    }
    private ListNode revert(ListNode h) {
        ListNode curr = h;
        ListNode n = h;
        ListNode p = null;

        while (curr.next != null) {
            n = curr.next;
            curr.next = p;
            p = curr;
            curr = n;
        }
        curr.next = p;
        return curr;
    }
}

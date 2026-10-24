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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int i = 1;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next;

            if (i % 2 == 0) {
                slow = slow.next;
            }

            i++;

            if (slow.equals(fast)) {
                return true;
            }
        }
    }
}

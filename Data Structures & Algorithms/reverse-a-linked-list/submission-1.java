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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode n = head;
        ListNode p = null;
        if(head == null) {
            return head;
        }

        while(curr.next != null) {
             n = curr.next;
             curr.next = p;
             p = curr;
             curr = n;
        }
        curr.next = p;
        System.out.println("TEST " + curr.next);
        return curr;
    }
}

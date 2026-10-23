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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            if(list2 != null) {
                return list2;
            }
        }
        if(list2 == null) {
            if(list1 != null) {
                return list1;
            }
        }
        if(list1 == null && list2 == null) {
            return null;
        }
        ListNode head = list1.val < list2.val ? list1 : list2;
        ListNode notCurr = list1.val >= list2.val ? list1 : list2;
        ListNode curr = head;
        boolean doWhile = true;
        while (doWhile) {
            ListNode smaller = findSmaller(curr.next, notCurr);
            if (smaller == null) {
                doWhile = false;
            }
            if (doWhile) {
                if (smaller.equals(notCurr)) {
                    var tmp = curr.next;
                    // Zapisujemy w AKTUALNYM head nexta
                    curr.next = notCurr;
                    // Na potrzeby sortowania zmieniamy head, teraz pracujemy na notCurr,
                    curr = notCurr;
                    notCurr = tmp;

                } else {
                    curr = curr.next;
                }
            }
        }
        return head;
    }

    private ListNode findSmaller(ListNode f, ListNode s) {
        if (f == null && s == null) {
            return null;
        }
        if (f == null) {
            return s;
        } else if (s == null) {
            return f;
        }
        if (f.val < s.val) {
            return f;
        } else {
            return s;
        }
    }
}
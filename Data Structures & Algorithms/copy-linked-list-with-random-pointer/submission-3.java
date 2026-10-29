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

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();
        Node previousValue = null;
        while (curr != null) {

            Node n = new Node(curr.val);
            if (previousValue != null) {
                map.get(previousValue).next = n;
            }
            previousValue = curr;

            map.put(previousValue, n);

            curr = curr.next;
        }
        if (map.get(previousValue).next != null) {
            map.get(previousValue).next = null;
        }
        System.out.println(map.size());

        curr = head;
        Node currCopy = null;
        while (curr != null) {
            currCopy = map.get(curr);
            if (curr.random == null) {
                currCopy.random = null;
            } else {
                currCopy.random = map.get(curr.random);
            }
            curr = curr.next;
        }

        return map.get(head);
    }
}

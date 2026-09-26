/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    Node newHead = null;
    Node tail = null;

    public Node flatten(Node head) {
        if(head == null)return head;

        addNode(head.val);
        flatten(head.child);
        flatten(head.next);

        return newHead;
    }

    private void addNode(int val){
        Node curr = new Node(val);
        if(newHead == null){
            newHead = tail = curr;
            return;
        }

        tail.next = curr;
        curr.prev = tail;
        tail = tail.next;
    }
}

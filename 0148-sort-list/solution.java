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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        
        ListNode left = head;
        ListNode mid = findMid(left);
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;

        while(fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode node = new ListNode();
        ListNode merged = node;
        while(left != null && right != null) {
            if(left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }

        if(left!=null) {
            node.next = left;
            node = node.next;
        }

        if(right!=null) {
            node.next = right;
            node = node.next;
        }

        return merged.next;
    }
}


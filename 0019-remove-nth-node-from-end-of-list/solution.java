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
        ListNode temp = head;
        int c = 0;
        
        while (temp != null) {
            temp = temp.next;
            c++;
        }

        if (c == n) {
            head = head.next;
            return head;
        }

        ListNode temp2 = head;
        for (int i = 1; i < c - n; i++) {
            temp2 = temp2.next;
        }

        temp2.next = temp2.next.next;
        return head;
    }
}


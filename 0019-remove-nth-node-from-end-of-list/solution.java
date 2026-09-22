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
        int sz = 0;

        while(temp != null){
            sz++;
            temp = temp.next;
        }

        temp = head;

        if(sz == n){
            return head.next;
        }

        while(temp != null && temp.next != null){
            sz--;
            if(sz == n){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode A = head;
        ListNode B = head;
        
        while (B != null && B.next != null) {
            A = A.next;
            B = B.next.next;
            
            if (A == B) {
                return true;
            }
        }
        return false;
    }
}


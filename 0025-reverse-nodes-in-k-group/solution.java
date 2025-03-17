class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        int length = 0;
        ListNode temp = head;
        while (temp != null) { 
            length++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (length >= k) {
            ListNode curr = prev.next;
            ListNode agla = curr.next;
            
            for (int i = 1; i < k; i++) {
                curr.next = agla.next;
                agla.next = prev.next;
                prev.next = agla;
                agla = curr.next;
            }

            prev = curr;
            length -= k;
        }

        return dummy.next;
    }
}


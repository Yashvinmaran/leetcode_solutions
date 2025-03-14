class Solution {
    public ListNode removeNodes(ListNode head) {
        head = Reverse(head);
        
        ListNode temp = head;
        ListNode prev = null; 
        while (temp != null && temp.next != null) {
            if (temp.next.val < temp.val) {
                temp.next = temp.next.next; 
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        
        head = Reverse(head);
        return head;
    }

    private ListNode Reverse(ListNode temp) {
        if (temp == null || temp.next == null) {
            return temp;
        }
        ListNode newHead = Reverse(temp.next);
        temp.next.next = temp; 
        temp.next = null;

        return newHead;
    }
}


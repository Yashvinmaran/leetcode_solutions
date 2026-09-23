class Solution { 
    public void reorderList(ListNode head) { 
        if (head == null || head.next == null) return;

        ListNode prev = null, curr = head, next = null; 
        ListNode fast = head; 
        

        while(fast != null && fast.next != null){ 
            curr = curr.next; 
            fast = fast.next.next; 
        } 
        

        while(curr != null){ 
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        } 
        
        ListNode temp = head; 
        while(temp != null && prev != null){ 
            ListNode next1 = temp.next;
            ListNode next2 = prev.next;
            
            temp.next = prev;
            
            if (next1 == prev || temp == prev) {
                prev.next = null;
                break;
            }
            
            prev.next = next1;
            
            temp = next1;
            prev = next2;
        } 
    } 
}


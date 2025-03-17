class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode temp1, temp2;
        temp1 = temp2 = head;

        while (temp1 != null && temp1.next != null) { 
            temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.val == temp2.val) {
                    temp1.next = temp2.next;
                } else {
                    temp1 = temp1.next;
                }
                temp2 = temp2.next;
            }
        }
        return head;
    }
}


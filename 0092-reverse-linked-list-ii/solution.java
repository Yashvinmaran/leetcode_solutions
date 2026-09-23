class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode start = head;
        ListNode end = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev1 = dummy;
        for (int i = 1; i <= right; i++){
            if(i < left){
                prev1 = start;
                start = start.next;
            }
            if(i < right){
                end = end.next;
            }
        }

        ListNode next1 = end.next;
        ListNode prev = null, next = null;
        ListNode temp = start;
        while(start != next1){
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }

        prev1.next = prev;
        temp.next = next1;

        return dummy.next;
    }
}

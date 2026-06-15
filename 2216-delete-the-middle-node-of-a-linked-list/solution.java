class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        if(head.next == null)return null;


        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        if(slow.next != null)prev.next = slow.next;
        else prev.next = null;

        return head;
    }
}

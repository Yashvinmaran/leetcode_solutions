class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode dummy = null;
        ListNode tail = null;
        ListNode temp = head;

        int c = 0;
        while (temp != null) {
            c++;
            if (c >= left && c <= right) {
                ListNode add = new ListNode(temp.val);
                if (dummy == null) {
                    dummy = add;
                    tail = dummy;
                } else {
                    add.next = dummy;
                    dummy = add;
                }
            }
            temp = temp.next;
        }

        ListNode newHead = new ListNode(0); 
        newHead.next = head;
        ListNode prev = newHead;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode after = prev.next;
        for (int i = left; i <= right; i++) {
            after = after.next;
        }

        prev.next = dummy;

        if (tail != null) {
            tail.next = after;
        }

        return newHead.next;
    }
}


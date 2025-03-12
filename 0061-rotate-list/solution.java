class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode temp = head;
        int length = 1;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        temp.next = head;
        int newHead = length - k;

        while (newHead >= 1) {
            temp = temp.next;
            newHead--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}


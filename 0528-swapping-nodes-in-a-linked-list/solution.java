class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            slow = slow.next;
        }

        ListNode fast = head;
        ListNode temp = slow;
        while (temp.next != null) {
            temp = temp.next;
            fast = fast.next;
        }

        int val = slow.val;
        slow.val = fast.val;
        fast.val = val;

        return head;
    }
}

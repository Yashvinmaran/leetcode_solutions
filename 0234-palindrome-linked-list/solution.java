class Solution {
    private ListNode Rev(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midLeft = Rev(slow);
        ListNode start = head;

        while (midLeft != null) {
            if (start.val != midLeft.val) return false;
            start = start.next;
            midLeft = midLeft.next;
        }
        return true;
    }
}


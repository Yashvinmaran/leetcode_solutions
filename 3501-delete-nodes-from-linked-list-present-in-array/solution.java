class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> deletable = new HashSet<>();
        for (int num : nums) deletable.add(num);

        while (head != null && deletable.contains(head.val)) {
            head = head.next;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (deletable.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}

class Solution {

     private static ListNode findMid(ListNode head) {
        
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;

        return slow;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }
}

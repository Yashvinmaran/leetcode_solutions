class Solution {

    private static ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while(left != null && right != null){
            if(left.val <= right.val){
                tail.next = left; 
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if(left != null){
            tail.next = left;
        }
        if(right != null){
            tail.next = right;
        }

        return dummy.next;
    }

    private static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        // Fixed: Re-enabled base case to prevent StackOverflowError
        if(head == null || head.next == null) return head;

        ListNode left = head;
        ListNode mid = findMid(left);
        ListNode right = mid.next;

        mid.next = null; // Break the list into two halves

        // Fixed: Capture the returned heads of the sorted sublists
        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }
}


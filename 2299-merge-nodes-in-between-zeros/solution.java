class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = new ListNode(0);
        ListNode curr = newList;
        ListNode temp = head.next;
        int sum = 0;

        while(temp != null){
            if(temp.val != 0){
                sum += temp.val;
            } else {
                curr.next = new ListNode(sum);
                curr = curr.next;
                sum = 0;
            }
            temp = temp.next;
        }

        return newList.next;
    }
}


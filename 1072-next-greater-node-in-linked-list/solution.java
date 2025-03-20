class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int c = 0;
        while(temp != null){
            c++;
            temp = temp.next;
        }
        int arr[] = new int[c];
        int i = 0;
        for (ListNode temp1 = head; temp1 != null; temp1 = temp1.next){
            for (ListNode temp2 = temp1.next; temp2 != null; temp2 = temp2.next){
                if(temp1.val < temp2.val){
                    arr[i] = (temp2.val);
                    break;
                }
            }i++;
        }
        return arr;
    }
}

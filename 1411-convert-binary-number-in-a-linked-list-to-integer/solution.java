class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int sum = 0;
        int pow = 0;
        while(temp.next != null){
            pow ++;
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            sum += (temp.val * Math.pow(2,pow--));
            temp = temp.next;
        }
        return sum;
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode temp = head;
        int c = 0;
        int sum = 0;
        while(temp != null){
            c++;
            temp = temp.next;
        }
        c--;
        temp = head;
        while(temp != null){
            sum += (Math.pow(2,c--)*temp.val);
            temp = temp.next;
        }
        return sum;
    }
}

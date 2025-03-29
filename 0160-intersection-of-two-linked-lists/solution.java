public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)return headA;
        if(headA == headB)return headA;

        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int lengthA = 0, lengthB = 0;

        while(temp1 != null){
            lengthA++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            lengthB++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;
        int diff = Math.abs(lengthA - lengthB);

        if(lengthA > lengthB){
            for (int i = 0; i < diff; i++){
                temp1 = temp1.next;
            }
        }else{
            for (int i = 0; i < diff; i++){
                temp2 = temp2.next;
            }
        }

        while(temp1 != null && temp2 != null){
            if(temp1 == temp2)return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}

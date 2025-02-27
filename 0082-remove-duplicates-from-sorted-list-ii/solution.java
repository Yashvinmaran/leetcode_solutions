/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode store = null;
        ListNode temp1 = head;
        ListNode temp2;
        Boolean flag;

        while (temp1 != null) {
            flag = false;
            for (temp2 = temp1.next; temp2 != null; temp2 = temp2.next) {
                if (temp1.val == temp2.val) {
                    temp2.val = 301;
                    flag = true;
                }
            }

            if (!flag && store == null && temp1.val != 301) {
                store = temp1;
                head = store;
            } else if (!flag && store != null && temp1.val != 301) {
                store.next = temp1;
                store = store.next;
            }

            temp1 = temp1.next;
        }

        if (store != null) {
            store.next = null;
        }else{
            head = null;
        }

        return head;        
    }
}


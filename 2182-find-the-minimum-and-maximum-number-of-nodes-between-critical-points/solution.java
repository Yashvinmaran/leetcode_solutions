class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head.next;
        ListNode prev = head;
        int[] ans = new int[]{-1, -1};
        int firstCp = -1; 
        int prevCp = -1;  
        int minDistance = Integer.MAX_VALUE;
        int cnt = 0;

        while (temp.next != null) {
            cnt++;
            if ((prev.val > temp.val && temp.val < temp.next.val) || 
                (prev.val < temp.val && temp.val > temp.next.val)) {
                
                if (firstCp == -1) {
                    firstCp = cnt;
                } else {
                    minDistance = Math.min(minDistance, cnt - prevCp);
                }
                prevCp = cnt;
            }
            prev = temp;
            temp = temp.next;
        }

        if (firstCp == -1 || prevCp == firstCp) {
            return ans;
        }

        ans[0] = minDistance;
        ans[1] = prevCp - firstCp;
        return ans;
    }
}


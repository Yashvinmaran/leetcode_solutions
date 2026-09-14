class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> qu = new LinkedList<>();

        for (int i = 0; i < k; i++){
            while(!qu.isEmpty() && nums[qu.peekLast()] < nums[i]){
                qu.pollLast();
            }
            qu.addLast(i);
        }

        ans[0] = nums[qu.peekFirst()];

        for (int i = k; i < nums.length; i++){
            while(!qu.isEmpty() && nums[qu.peekLast()] <= nums[i]){
                qu.pollLast();
            }
            qu.addLast(i);
            while(qu.peekFirst() <= (i - k)){
                qu.pollFirst();
            }
            ans[i-k+1] = nums[qu.peekFirst()];
        }

        return ans;
    }
}

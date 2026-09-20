class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n= nums.length;

        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;


        for (int i = 2 * n - 1; i >= 0; i--){
            while(top != -1 && nums[stack[top]] <= nums[i%n]){
                top--;
            }

            if(top == -1)ans[i%n] = -1;
            else ans[i%n] = nums[stack[top]];

            stack[++top] = (i%n);
        }

        return ans;
    }
}

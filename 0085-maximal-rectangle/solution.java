class Solution {

    private static int calculateWidth(int[] nums){
        int n = nums.length;

        int[] nse = new int[n];
        int[] pse = new int[n];
        int[] stack = new int[n];

        int top = -1;

        for (int i = n - 1; i >= 0; i--){
            while(top != -1 && nums[stack[top]] >= nums[i]){
                top--;
            }
            nse[i] = (top == -1) ? n : stack[top];
            stack[++top] = i;
        }

        top = -1;
        for (int i = 0; i < n; i++){
            while(top != -1 && nums[stack[top]] >= nums[i]){
                top--;
            }
            pse[i] = (top == -1) ? -1 : stack[top];
            stack[++top] = i;
        }

        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i] * (nse[i] - pse[i] - 1));
        }
        
        return max;
    }

    public int maximalRectangle(char[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
        
        int m = mat.length;
        int n = mat[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (mat[i][j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, calculateWidth(heights));
        }

        return maxArea;
    }
}


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        int[] stack = new int[n];
        int top = -1; 
        
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && temperatures[stack[top]] <= temperatures[i]) {
                top--;
            }
            
            if (top >= 0) {
                ans[i] = stack[top] - i;
            } else {
                ans[i] = 0;
            }
            
            stack[++top] = i;
        }
        
        return ans;
    }
}


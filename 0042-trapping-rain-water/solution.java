class Solution {
    public int trap(int[] height) {
        
        int ans = 0;

        int left = 0;
        int right = height.length - 1;

        int maxLeft = height[left];
        int maxRight = height[right];

        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(maxLeft < maxRight){
                ans += maxLeft - height[left];
                left++;
            }else {
                ans += maxRight - height[right];
                right--;
            }
        }

        return ans;
    }
}

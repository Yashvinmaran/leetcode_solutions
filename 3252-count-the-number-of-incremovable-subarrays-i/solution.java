class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 2) return 3;
        
        int ans = 1;

        int left = 0;
        while(left < n-1 && nums[left] < nums[left+1]) {
            left++;
        }
        ans += left + 1;
        
        // right increasing
        int right = n-1;
        while(right > 0 && nums[right-1] < nums[right]) {
            right--;
        }
        ans += n - right;
            
        // if all are increasing
        if(left >= right) {
            return ((n)*(n+1))/2;
        }

        left = 0;
        // middle handling
        while(left < right && right < n) {
            if(nums[left] < nums[right]) {
                ans += right == n-1 ? 1l : (n-right);
                if(left < n-1 && nums[left] < nums[left+1])
                    left++;
                else 
                    break;
            } else {
                right++;
            }
        }
        
        return ans;
    }
}

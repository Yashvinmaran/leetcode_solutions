class Solution {
    public int threeSumClosest(int[] nums, int tar) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == tar) {
                    return tar; 
                }
                
                if (Math.abs(sum - tar) < Math.abs(closestSum - tar)) {
                    closestSum = sum;
                }
                
                if (sum < tar) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestSum;
    }
}


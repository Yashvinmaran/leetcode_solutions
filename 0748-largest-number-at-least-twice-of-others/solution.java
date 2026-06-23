class Solution {
    public int dominantIndex(int[] nums) {
        int max = nums[0]; 
        int idx = 0;
        
        for (int n = 0; n < nums.length; n++){
            if(nums[n] > max){ 
                idx = n;
                max = nums[n];
            }
        }
        
        for (int i = 0; i < nums.length; i++){
           
            if(i != idx && max < 2 * nums[i]) return -1;
        }
        
        return idx;
    }
}


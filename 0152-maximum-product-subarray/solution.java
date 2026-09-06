class Solution {
    public int maxProduct(int[] nums) {
        
        int prefix = 1;
        int suffix = 1;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            prefix *= nums[i];
            suffix *= nums[nums.length - 1 - i];

            max = Math.max(Math.max(suffix, prefix), max);
            if(suffix == 0)suffix = 1;
            if(prefix == 0)prefix = 1;
        }

        return max;
    }
}

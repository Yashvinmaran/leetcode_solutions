class Solution {
    public int maxProduct(int[] nums) {
        int max_product = Integer.MIN_VALUE;
        int suffix_product = 1;
        int prefix_product = 1;

        for (int i = 0; i < nums.length; i++){
            prefix_product *= nums[i];
            suffix_product *= nums[nums.length - i - 1];

            max_product = Math.max(max_product, Math.max(prefix_product, suffix_product));
            
            if(prefix_product == 0)prefix_product = 1;
            if(suffix_product == 0)suffix_product = 1;
        }

        return max_product;
    }
}

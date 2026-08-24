class Solution {
    public int findMiddleIndex(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[0] = nums[n-1];

        for (int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + nums[i];
            suffix[i] = suffix[i - 1] + nums[n - i - 1];
        }

        for (int i = 0; i < n; i++){
            if(suffix[n - i - 1] == prefix[i])return i;
        }

        return -1;

        // 2 5 4 12 16
        // 4 12 11 14 16
    }
}

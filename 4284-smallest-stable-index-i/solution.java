class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++){
            int max = nums[i];
            int min = nums[i];
            int j = 0;
            while(j <= i){
                max = Math.max(max, nums[j]);
                j++;
            }
            j = i;
            while(j < n){
                min = Math.min(min, nums[j]);
                j++;
            }

            if((max - min) <= k)return i;
        }

        return -1;
    }
}

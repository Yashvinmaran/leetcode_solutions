class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int min = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 1; i < n; i++){
            if(nums[i - 1] == nums[i])cnt++;
            else cnt = 0;
            if(cnt > 1){
                nums[i-2] = min;
                cnt--;
            }
        }

        int left = 0;
        for (int right = 0; right < n; right++){
            if(nums[right] != min){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}

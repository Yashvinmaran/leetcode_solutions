class Solution {

    private static boolean isPossible(int[] nums, int take, int k){
        int sum = 0;
        int part = k;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > take){
                part--;
                sum = nums[i];
            }
            if(part == 0)return false;
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {
        
        int low = 0;
        int high = 0;

        for (int i = 0; i < nums.length; i++){
            low = Math.max(nums[i], low);
            high += nums[i];
        }

        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(nums, mid, k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}

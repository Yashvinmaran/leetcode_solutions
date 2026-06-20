class Solution {

    private int search(int left, int right, int[] nums, int target){

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] < target){
                left = mid + 1;
            }else right = mid;
        }

        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        if(right < 0)return ans;

        int idx = search(left, right, nums, target);

        if(nums[idx] != target)return ans;


        while(idx >= 0 && nums[idx] == target){
            ans[0] = idx--;
        }
        idx = ans[0];
        while(idx <= right && nums[idx] == target){
            ans[1] = idx++;
        }

        return ans;
    }
}

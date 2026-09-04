class Solution {
    public int majorityElement(int[] nums) {
        int curr = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++){
            if(cnt == 0){
                curr = nums[i];
                cnt++;
            }else if(nums[i] == curr)cnt++;
            else cnt--;
        }

        int cnt1 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == curr)cnt1++;
            if(cnt1 > (nums.length/2))return curr;
        }
        return -1;
    }
}

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
                int count = 1;
        int maxLen = 0;
        int res = 0;
        int n = nums.size();
        for(int i = 1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                count++;
            }else{
                maxLen = count;
                count = 1;
            }
            res = Math.max(res,Math.min(maxLen,count));
            res = Math.max(res,count/2);
        }
        return res;
    }
}

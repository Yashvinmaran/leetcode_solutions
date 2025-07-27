class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        List<Integer> list = new ArrayList<>();
        int sum2 = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            list.add(nums[i]);
            sum2 += nums[i];
            sum -= nums[i];
            if(sum < sum2)return list;
        }
        return list;
    }
}

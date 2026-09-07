class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int idx = 0;

        for (int i = 0; i < nums.length; i++){
            idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0){
                ans.add(Math.abs(nums[i]));
            }else nums[idx] *= -1;
        }

        return ans;
    }
}

class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();

        int next = lower;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= upper; i++){
            if(next > nums[i])continue;

            if(next < nums[i]){
                ans.add(new ArrayList<>(Arrays.asList(next, nums[i] - 1)));
            }

            next = nums[i] + 1;
        }

        if(next <= upper){
            ans.add(Arrays.asList(next,upper));
        }

        return ans;
    }
}

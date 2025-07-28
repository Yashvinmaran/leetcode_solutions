class Solution {

    private void helper(int[] nums,List<List<Integer>> result, List<Integer> subset, int i){
        if(i == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        helper(nums, result, subset, i + 1);
        subset.remove(subset.size() - 1);
        helper(nums, result, subset, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper (nums, allSubsets, subset, 0);
        return allSubsets;
    }
}

class Solution {

    private void helper(int[] nums, Set<List<Integer>> ans, List<Integer> result, int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(result));
            return;
        }
        result.add(nums[i]);
        helper(nums, ans, result, i + 1);
        result.remove(result.size() - 1);
        helper(nums, ans, result, i + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, ans, result, 0);
        List<List<Integer>> all = new ArrayList<>(); 
        for (var a : ans){
            all.add(a);
        }
        return all;
    }
}

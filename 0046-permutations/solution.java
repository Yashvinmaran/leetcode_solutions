class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        findPermutation(nums, result, 0, n-1);
        return result;
    }

    public void findPermutation(int[] nums, List<List<Integer>> result, int idx, int n){
        if(idx == n){
            List<Integer> current = new ArrayList<>();
            for (int num : nums){
                current.add(num);
            }
            result.add(current);
            return;
        }

        for (int i = idx; i<=n; i++){
            swap(nums, i, idx);
            findPermutation(nums, result, idx+1, n);
            swap(nums, i, idx);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

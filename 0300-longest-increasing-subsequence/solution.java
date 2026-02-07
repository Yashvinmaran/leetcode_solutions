// class Solution {

//     private boolean check(List<Integer> res){
//         for (int i = 1; i < res.size(); i++){
//             if(res.get(i-1) >= res.get(i))return false;
//         }
//         return true;
//     }

//     private void helper(int[] nums, List<List<Integer>> result, List<Integer> curr, int idx) {
//         if (idx == nums.length) {
//             result.add(new ArrayList<>(curr));
//             return;
//         }
//         curr.add(nums[idx]);
//         helper(nums, result, curr, idx + 1);
//         curr.remove(curr.size() - 1);
//         helper(nums, result, curr, idx + 1);
//     }

//     public int lengthOfLIS(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();

//         helper(nums, result, new ArrayList<>(), 0);
//         int max = 0;
//         for (var res : result) {
//             if(check(res)){
//                 max = Math.max(max, res.size());
//             }
//         }
//         return max;
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

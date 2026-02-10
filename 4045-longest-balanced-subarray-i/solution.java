class Solution {
    public int longestBalanced(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int even = 0;
            int odd = 0;
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    if (nums[j] % 2 == 0)even++;
                    else odd++;
                }if (even == odd) max = Math.max(max, (j - i) + 1);
            }
        }
        return max;
    }
}

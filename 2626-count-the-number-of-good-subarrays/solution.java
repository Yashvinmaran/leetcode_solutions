class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        long res = 0, pairs = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            int count = mpp.getOrDefault(nums[right], 0);
            pairs += count;
            mpp.put(nums[right], count + 1);
            while (pairs >= k) {
                res += n - right;
                int leftCount = mpp.get(nums[left]);
                pairs -= leftCount - 1;
                if (leftCount == 1) mpp.remove(nums[left]);
                else mpp.put(nums[left], leftCount - 1);
                left++;
            }
        }
        return res;
    }
}


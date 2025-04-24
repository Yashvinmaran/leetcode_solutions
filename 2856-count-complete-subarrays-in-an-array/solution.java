class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] freq = new int[2001];
        boolean[] seen = new boolean[2001];
        int k = 0;
        for (int num : nums) {
            if (!seen[num]) {
                seen[num] = true;
                k++;
            }
        }
        int i = 0, j = 0, count = 0, distinct = 0;
        while (j < nums.length) {
            if (freq[nums[j]] == 0) distinct++;
            freq[nums[j]]++;
            while (distinct == k) {
                count += (nums.length - j);
                freq[nums[i]]--;
                if (freq[nums[i]] == 0) distinct--;
                i++;
            }
            j++;
        }
        return count;
    }
}


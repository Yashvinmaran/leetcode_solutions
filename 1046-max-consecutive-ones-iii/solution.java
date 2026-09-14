class Solution {
    public int longestOnes(int[] nums, int k) {

        int maxOnes = 0;
        int left = 0;
        
        int[] cnt = new int[2];

        for (int right = 0; right < nums.length; right++){

            cnt[nums[right]]++;
            while(cnt[0] > k){
                cnt[nums[left]]--;
                left++;
            }

            maxOnes = Math.max(maxOnes, (right - left + 1));
        }

        return maxOnes;
    }
}

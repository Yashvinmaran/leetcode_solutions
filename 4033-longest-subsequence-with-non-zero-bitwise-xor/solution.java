class Solution {
    public int longestSubsequence(int[] nums) {
        
        int xor = 0;
        int cnt = 0;
        int n = nums.length;

        for (int num : nums){
            xor ^= num;
            if(num == 0)cnt++;
        }

        if(cnt == n)return 0;
        if(xor != 0)return n;
        
        return n - 1;
    }
}

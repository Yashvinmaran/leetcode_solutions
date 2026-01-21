class Solution {

    private int fill(int num){
        for (int i = 31; i >= 0; i--){
            if((num & (1 << i)) != 0){
                int flip = num ^ (1 << i);
                if((flip | (flip + 1)) == num) return flip;
            }
        }
        return -1;
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++){
            ans[i] = fill(nums.get(i));
        }
        return ans;
    }
}

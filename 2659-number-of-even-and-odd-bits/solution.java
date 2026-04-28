class Solution {
    public int[] evenOddBit(int n) {
        int bit = 1;
        int[] ans = new int[2];
        for (int i = 0; n > 0; i++){
            if((n & bit) == 1){
                if(i % 2 == 0)ans[0]++;
                else ans[1]++;
            }
            n = n >> 1;
        }
        return ans;
    }
}

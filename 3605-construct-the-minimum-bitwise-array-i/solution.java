class Solution {

    private int fill(int num){
        for (int i = 1; i <= num; i++){
            if((i|(i + 1)) == num)return i;    
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

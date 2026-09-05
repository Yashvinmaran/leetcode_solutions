class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        int[] minArray = new int[n];
        int[] maxArray = new int[n];

        minArray[0] = nums[n - 1];
        maxArray[0] = nums[0];

        for (int i = 1; i < n; i++){
            maxArray[i] = Math.max(maxArray[i-1],nums[i]);
            minArray[i] = Math.min(minArray[i-1],nums[n - i - 1]);
        }

        for (int i = 0; i < n; i++){
            int currDiff = (maxArray[i] - minArray[n - i - 1]);
            if(currDiff <= k)return i;
        }

        return -1;
    }
}

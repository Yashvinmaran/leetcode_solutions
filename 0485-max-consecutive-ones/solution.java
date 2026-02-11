class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums){
            if(num == 0)sum = 0;
            sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }
}

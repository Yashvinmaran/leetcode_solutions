class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0.0;
        for (int i = 0; i<k; i++){
            avg += nums[i];
        }
        double max_avg = avg/k;
        for (int i = k; i<nums.length; i++){
            avg += nums[i];
            avg -= nums[i - k];
            max_avg = Math.max(avg/k, max_avg);
        }
        return max_avg;
    }
}

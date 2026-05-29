class Solution {
    
    private static int digitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public int minElement(int[] nums) {
        int min_sum = Integer.MAX_VALUE;

        for (int num : nums){
            min_sum = Math.min(min_sum, digitSum(num));
        }

        return min_sum;
    }
}

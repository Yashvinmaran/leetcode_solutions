class Solution {
    public int maxSum(int[] nums) {
        boolean[] seen = new boolean[201];
        int sum = 0;
        int maxNegative = Integer.MIN_VALUE;
        boolean hasPositive = false;

        for (int num : nums) {
            if (num >= 0) {
                if (!seen[num + 100]) {
                    sum += num;
                    seen[num + 100] = true;
                    hasPositive = true;
                }
            } else {
                maxNegative = Math.max(maxNegative, num);
            }
        }

        return hasPositive ? sum : maxNegative;
    }
}


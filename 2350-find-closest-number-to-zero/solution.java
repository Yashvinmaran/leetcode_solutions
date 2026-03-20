class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int absCurr = Math.abs(current);
            int absClosest = Math.abs(closest);

            if (absCurr < absClosest || (absCurr == absClosest && current > closest)) {
                closest = current;
            }
        }

        return closest;
    }
}


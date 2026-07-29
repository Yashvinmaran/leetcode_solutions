class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        // Track presence of numbers from 1 to 102
        boolean[] present = new boolean[105];

        for (int num : nums) {
            sum += num;
            // Only track positive numbers within our search bounds
            if (num > 0 && num <= 102) {
                present[num] = true;
            }
        }

        // Integer division truncation rules: 
        // e.g. 8 / 2 = 4 (strictly greater becomes 5)
        // e.g. 2 / 3 = 0 (strictly greater becomes 1)
        int avgFloor = sum / n;
        
        // If sum is negative and truncates towards zero (like -2/3 = 0), 
        // or if avg floor is negative, Math.max handles starting from 1.
        if (sum < 0 && sum % n != 0) {
            avgFloor--; // Correct integer division towards negative infinity
        }

        // Candidate must be strictly positive (>=1) AND strictly greater than average
        int candidate = Math.max(1, avgFloor + 1);

        // Find the smallest positive index marked as false
        while (candidate < 105 && present[candidate]) {
            candidate++;
        }

        return candidate;
    }
}


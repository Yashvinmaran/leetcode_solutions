class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        
        // In a good array, the maximum value 'base' must be exactly n - 1
        int base = n - 1;
        
        // Count frequencies of each number using a frequency array
        int[] count = new int[n]; 
        
        for (int num : nums) {
            // If any number is out of the valid range [1, base], it is invalid
            if (num < 1 || num > base) {
                return false;
            }
            count[num]++;
        }
        
        // Validate frequencies: 
        // Numbers from 1 to base - 1 must appear exactly once
        for (int i = 1; i < base; i++) {
            if (count[i] != 1) return false;
        }
        
        // The maximum value (base) must appear exactly twice
        return count[base] == 2;
    }
}


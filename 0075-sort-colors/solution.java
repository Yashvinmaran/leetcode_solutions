class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (mid <= right) {
            if (nums[mid] == 0) {
                // Only XOR if indices are different to avoid resetting to 0
                if (mid != left) {
                    nums[mid] ^= nums[left];
                    nums[left] ^= nums[mid];
                    nums[mid] ^= nums[left];
                }
                left++;
                mid++;
            } else if (nums[mid] == 2) {
                // Only XOR if indices are different
                if (mid != right) {
                    nums[mid] ^= nums[right];
                    nums[right] ^= nums[mid];
                    nums[mid] ^= nums[right];
                }
                
                right--; 
            } else {
                mid++;
            }
        }
    }
}


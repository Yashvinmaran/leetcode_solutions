class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 1. Sort the array first
        Arrays.sort(nums);
        
        List<Integer> result = new ArrayList<>();
        
        // 2. Find the first and last occurrence of the target
        int firstIdx = findFirst(nums, target);
        
        // If the target is not in the array, return the empty list
        if (firstIdx == -1) {
            return result;
        }
        
        int lastIdx = findLast(nums, target);
        
        // 3. Fill the list with all indices from firstIdx to lastIdx
        for (int i = firstIdx; i <= lastIdx; i++) {
            result.add(i);
        }
        
        return result;
    }
    
    // Binary search for the first occurrence
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;       // Potential answer
                right = mid - 1;   // Keep looking left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
    
    // Binary search for the last occurrence
    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;       // Potential answer
                left = mid + 1;    // Keep looking right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}


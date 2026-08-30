class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int leftIdx = Math.min(minIdx, maxIdx);
        int rightIdx = Math.max(minIdx, maxIdx);
        
        int pullBothFromFront = rightIdx + 1;
        
        int pullBothFromBack = n - leftIdx;
        
        int pullFromBothSides = (leftIdx + 1) + (n - rightIdx);

        int total = Math.min(pullBothFromFront, Math.min(pullBothFromBack, pullFromBothSides));
        
        return total;
    }
}


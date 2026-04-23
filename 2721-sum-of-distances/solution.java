class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> groupIndices = new HashMap<>();

        // 1. Group indices for each value
        for (int i = 0; i < n; i++) {
            groupIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // 2. Process each group using prefix sum logic
        for (List<Integer> indices : groupIndices.values()) {
            int size = indices.size();
            long totalSumOfIndices = 0;
            for (int index : indices) {
                totalSumOfIndices += index;
            }

            long prefixSum = 0;
            for (int i = 0; i < size; i++) {
                long currentIndex = indices.get(i);
                
                // Sum of differences for indices to the left
                long leftDist = (long) i * currentIndex - prefixSum;
                
                // Sum of differences for indices to the right
                long suffixSum = totalSumOfIndices - prefixSum - currentIndex;
                long rightDist = suffixSum - (long) (size - 1 - i) * currentIndex;
                
                ans[(int) currentIndex] = leftDist + rightDist;
                
                prefixSum += currentIndex;
            }
        }

        return ans;
    }
}


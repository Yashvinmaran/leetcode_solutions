class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;

        // Stores the two most recent indices found for each number
        Map<Integer, int[]> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (!map.containsKey(val)) {
                // First time seeing the number: [firstIndex, secondIndex]
                map.put(val, new int[]{i, -1});
            } else {
                int[] indices = map.get(val);
                if (indices[1] == -1) {
                    // Second time seeing the number
                    indices[1] = i;
                } else {
                    // Third (or more) time seeing the number
                    // Distance for a triplet (indices[0], indices[1], i) is (i - indices[0]) * 2
                    minDistance = Math.min(minDistance, (i - indices[0]) * 2);
                    
                    // Shift indices to find the next potential triplet for this number
                    indices[0] = indices[1];
                    indices[1] = i;
                }
            }
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}


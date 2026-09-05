class Solution {
    public int longestConsecutive(int[] nums) {
        // Step 1: Populate the set to extract unique elements
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int max_len = 0;

        // Step 2: Iterate through the SET, not the array, to skip duplicates
        for (int n : set) {
            // Check if 'n' is the true absolute start of a sequence
            if (!set.contains(n - 1)) {
                int currentNum = n;
                int currentLen = 1;

                // Step 3: Count the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLen += 1;
                }

                // Step 4: Keep track of the maximum length found
                max_len = Math.max(max_len, currentLen);
            }
        }

        return max_len;
    }
}


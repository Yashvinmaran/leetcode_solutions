class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int start = 0;

        while (start < nums.length) {
            HashSet<Integer> set = new HashSet<>();
            boolean duplicateFound = false;

            for (int i = start; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    duplicateFound = true;
                    break;
                }
                set.add(nums[i]);
            }

            if (!duplicateFound) {
                break;
            }

            start += 3;
            operations++;
        }

        return operations;
    }
}


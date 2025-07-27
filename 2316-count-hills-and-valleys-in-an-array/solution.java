class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> cleaned = new ArrayList<>();
        cleaned.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                cleaned.add(nums[i]);
            }
        }
        int count = 0;
        for (int i = 1; i < cleaned.size() - 1; i++) {
            int prev = cleaned.get(i - 1);
            int curr = cleaned.get(i);
            int next = cleaned.get(i + 1);
            
            if ((prev < curr && curr > next) || (prev > curr && curr < next)) {
                count++;
            }
        }
        return count;
    }
}


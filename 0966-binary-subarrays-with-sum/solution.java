class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer, Integer> map = new HashMap<>();

        int currSum = 0;
        int totalSubArrays = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if(currSum == goal) totalSubArrays ++;
            
            if (map.containsKey(currSum - goal)) {
                totalSubArrays += map.get(currSum - goal);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return totalSubArrays;
    }
}


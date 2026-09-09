class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            
            for (int i = a + 1; i < nums.length; i++) {
                if (i > a + 1 && nums[i] == nums[i - 1]) continue;
                
                int j = i + 1;
                int k = nums.length - 1;
                
                while (j < k) {
                    long sum = (long) nums[a] + nums[i] + nums[j] + nums[k];
                    
                    if (sum == target) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[a], nums[i], nums[j], nums[k])));
                        j++;
                        k--;
                        
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    } else if (sum < target) {
                        j++; 
                    } else {
                        k--; 
                    }
                }
            }
        }
        return ans;
    }
}


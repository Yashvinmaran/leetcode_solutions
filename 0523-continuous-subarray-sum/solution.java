class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> store = new HashMap<>();
        int sum = 0;
        
        store.put(0, -1); 
        
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            int rem = (sum % k);
            
            if (store.containsKey(rem)) {
                if ((i - store.get(rem)) >= 2) return true;
            } else {
                store.put(rem, i); 
            }
        }
        return false;
    }
}


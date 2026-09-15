class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int curr = 0;
        for (int i = 0; i < nums.length; i++){
            curr += nums[i];
            if(curr == k)cnt++;
            if(map.containsKey(curr - k)){
                cnt += map.get(curr - k);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return cnt;
    }
}

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;


        while(left < n && right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if(map.get(nums[right]) > k){
                int check = nums[right];
                while(left <= right && map.get(check) > k){
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                    left++;
                }
            }
            cnt = Math.max(cnt, right - left + 1);
            right++;
        }

        return cnt;
    }
}

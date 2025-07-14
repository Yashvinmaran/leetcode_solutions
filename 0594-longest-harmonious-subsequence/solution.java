class Solution {
    public int findLHS(int[] nums) {
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int len = map.get(key) + map.get(key + 1);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}

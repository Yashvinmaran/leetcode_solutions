class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            map.put(x, map.getOrDefault(x, 0) + 1);
            count = Math.max(count, map.get(x));

            if (!first.containsKey(x)) {
                first.put(x, i);
            }
            last.put(x, i);
        }

        int minLen = nums.length;
        for (int x : map.keySet()) {
            if (map.get(x) == count) {
                minLen = Math.min(minLen, last.get(x) - first.get(x) + 1);
            }
        }

        return minLen;
    }
}

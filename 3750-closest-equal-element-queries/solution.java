class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        int n = nums.length;

        // Step 1: map value -> sorted indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        // Step 2: process each query
        for (int startIndex : queries) {

            int val = nums[startIndex];
            List<Integer> list = map.get(val);

            // if only one occurrence → no answer
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            // binary search to find position
            int pos = Collections.binarySearch(list, startIndex);

            int left = (pos - 1 + list.size()) % list.size();
            int right = (pos + 1) % list.size();

            int leftIndex = list.get(left);
            int rightIndex = list.get(right);

            int dist1 = Math.abs(startIndex - leftIndex);
            int dist2 = Math.abs(startIndex - rightIndex);

            int circular1 = Math.min(dist1, n - dist1);
            int circular2 = Math.min(dist2, n - dist2);

            ans.add(Math.min(circular1, circular2));
        }

        return ans;
    }
}

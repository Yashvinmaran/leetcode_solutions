class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getValue(), b.getValue()));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> val : map.entrySet()){
            pq.add(val);
            if(pq.size() > k) pq.poll();
            }
        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()){
            Map.Entry<Integer, Integer> a = pq.poll();
            ans[i++] = a.getKey();
        }
        return ans;
    }
}

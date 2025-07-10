class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(pq);
        list.sort((a, b) -> a.getKey() - b.getKey());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getValue();
        }
        return res;
    }
}


class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = calculateXSum(freq, x);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in = nums[i];

            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            freq.put(in, freq.getOrDefault(in, 0) + 1);

            ans[i - k + 1] = calculateXSum(freq, x);
        }

        return ans;
    }

    private int calculateXSum(Map<Integer, Integer> freq, int x) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> {
                if (!a.getValue().equals(b.getValue()))
                    return b.getValue() - a.getValue(); 
                return b.getKey() - a.getKey();
            });

        pq.addAll(freq.entrySet());

        int sum = 0, count = 0;
        while (!pq.isEmpty() && count < x) {
            Map.Entry<Integer, Integer> e = pq.poll();
            sum += e.getKey() * e.getValue();
            count++;
        }
        return sum;
    }
}


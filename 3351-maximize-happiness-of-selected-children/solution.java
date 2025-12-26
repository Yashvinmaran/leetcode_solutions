class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);  // O(n log n)

        long result = 0;
        int n = happiness.length;
        int picked = 0;

        for (int i = n - 1; i >= 0 && picked < k; i--) {
            int current = happiness[i] - picked;
            if (current <= 0) break;

            result += current;
            picked++;
        }
        return result;
    }
}


class Solution {
    public static int maxRotateFunction(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        long currentWeightedSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            currentWeightedSum += (long) i * arr[i];
        }

        long maxWeightedSum = currentWeightedSum;

        for (int i = 1; i < n; i++) {
            // The element that was at the end moves to index 0
            // In the i-th rotation, the element moving to index 0 is arr[n - i]
            currentWeightedSum = currentWeightedSum + totalSum - (long) n * arr[n - i];
            
            if (currentWeightedSum > maxWeightedSum) {
                maxWeightedSum = currentWeightedSum;
            }
        }

        return (int)maxWeightedSum;
    }
}

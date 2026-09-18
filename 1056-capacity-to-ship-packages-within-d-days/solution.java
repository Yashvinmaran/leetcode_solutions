class Solution {

    private static int calculateDays(int[] weights, int capacity) {
        int daysNeeded = 1; // Start with the 1st day
        int currentWeight = 0;

        for (int w : weights) {
            if (currentWeight + w > capacity) {
                daysNeeded++;      // Move to the next day
                currentWeight = w; // Start the new day with the current item
            } else {
                currentWeight += w;
            }
        }
        return daysNeeded;
    }

    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;

        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }

        int left = maxWeight; 
        int right = totalWeight;
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int daysTaken = calculateDays(weights, mid);

            if (daysTaken <= days) {
                ans = mid;      
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}


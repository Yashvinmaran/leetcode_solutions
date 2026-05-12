class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 1. Sort by units per box (index 1) descending
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int sum = 0;
        for (int[] box : boxTypes) {
            if (truckSize <= 0) break;
            
            // 2. Determine how many boxes we can actually take
            int count = Math.min(box[0], truckSize);
            sum += count * box[1];
            truckSize -= count;
        }
        return sum;
    }
}


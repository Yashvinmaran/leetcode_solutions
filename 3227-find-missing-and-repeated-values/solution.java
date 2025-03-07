class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long sumGrid = 0, sumSquaresGrid = 0;
        long S = (long) n * n * (n * n + 1) / 2;
        long S2 = (long) n * n * (n * n + 1) * (2 * n * n + 1) / 6;

        for (int[] row : grid) {
            for (int num : row) {
                sumGrid += num;
                sumSquaresGrid += (long) num * num;
            }
        }

        long diff1 = sumGrid - S;  
        long diff2 = sumSquaresGrid - S2;  

        long sumXY = diff2 / diff1;  

        int repeated = (int) ((diff1 + sumXY) / 2);
        int missing = (int) (sumXY - repeated);

        return new int[]{repeated, missing};
    }
}


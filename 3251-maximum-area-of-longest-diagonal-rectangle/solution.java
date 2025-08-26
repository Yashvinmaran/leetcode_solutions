class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = -1;
        double maxDiagonal = 0.0;

        for (int[] dim : dimensions) {
            int a = dim[0], b = dim[1];
            double diagonal = Math.sqrt((a * a) + (b * b));
            int area = a * b;

            if (diagonal > maxDiagonal || 
                (diagonal == maxDiagonal && area > ans)) {
                maxDiagonal = diagonal;
                ans = area;
            }
        }
        return ans;
    }
}


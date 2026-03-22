class Solution {
    private int[][] rotateMat(int[][] mat, int n) {
        int[][] res = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                res[c][n - 1 - r] = mat[r][c];
            }
        }
        return res;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            mat = rotateMat(mat, mat.length);
        }
        return false;
    }
}


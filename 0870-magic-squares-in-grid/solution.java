class Solution {

    private boolean isValid(int r, int c, int[][] grid) {

        if (grid[r + 1][c + 1] != 5) return false;

        boolean[] seen = new boolean[10];

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

        return
            sum == grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2] &&
            sum == grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2] &&
            sum == grid[r][c] + grid[r + 1][c] + grid[r + 2][c] &&
            sum == grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] &&
            sum == grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] &&
            sum == grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] &&
            sum == grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];
    }

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (row < 3 || col < 3) return 0;

        int count = 0;
        for (int r = 0; r <= row - 3; r++) {
            for (int c = 0; c <= col - 3; c++) {
                if (isValid(r, c, grid)) count++;
            }
        }
        return count;
    }
}


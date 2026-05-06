class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {

        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] arr = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                arr[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        for (int c = 0; c < m; c++) {
            int idx = n - 1;
            for (int r = n - 1; r >= 0; r--) {
                if (arr[r][c] == '*')
                    idx = r - 1;
                if (arr[r][c] == '#') {
                    arr[r][c] = '.';
                    arr[idx][c] = '#';
                    idx--;
                }
            }
        }
        return arr;
    }
}


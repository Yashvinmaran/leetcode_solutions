class Solution {
   public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] count = new int[1];
        nqueen(board, 0, count);
        return count[0];
    }

    private static void nqueen(char board[][], int row, int[] count) {
        int n = board.length;
        if (row == n) {
            count[0]++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueen(board, row + 1, count);
                board[row][j] = '.';
            }
        }
    }

    private static boolean isSafe(char board[][], int row, int col) {
        int n = board.length;

        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}


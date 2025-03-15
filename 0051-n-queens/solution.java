class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueen(board, 0, ans);
        return ans;
    }

    private static void nqueen(char board[][], int row, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l.add(new String(board[i])); 
            }
            ans.add(l);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nqueen(board, row + 1, ans);
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


class Solution {

    private boolean checkMatrics(char[][] board, int r, int c){
        boolean[] arr = new boolean[10];
        for(int i = r; i < (r+3); i++){   
            for(int j = c; j < (c+3); j++){
                if(board[i][j] == '.')continue;
                int  val = board[i][j] - '0';
                if(arr[val])return false;
                arr[val] = true;
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        
        //rows checker
        for (int i = 0; i < 9; i++){
            boolean[] arr = new boolean[10];
            for (int j = 0; j < 9; j++){
                if(board[i][j] == '.')continue;
                int  val = board[i][j] - '0';
                if(arr[val])return false;
                arr[val] = true;
            }
        }

        // coloms checker
         for (int i = 0; i < 9; i++){
            boolean[] arr = new boolean[10];
            for (int j = 0; j < 9; j++){
                if(board[j][i] == '.')continue;
                int val = board[j][i] - '0';
                if(arr[val])return false;
                arr[val] = true;
            }
        }

        //check matrics 3 x 3
        for (int i = 0; i < 9; i = i + 3){
            for(int j = 0; j < 9; j = j + 3){
                if(!checkMatrics(board, i, j))return false;;
            }
        }
        return true;
    }
}

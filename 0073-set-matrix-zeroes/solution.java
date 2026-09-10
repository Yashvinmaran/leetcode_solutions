import java.util.Arrays;

class Solution {

    public void setZeroes(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        
        boolean first_col_zero = false; 
        boolean first_row_zero = false;

        for (int i = 0; i < m; i++){
            if(mat[i][0] == 0){
                first_col_zero = true;
                break;
            }
        }

        for (int i = 0; i < n; i++){
            if(mat[0][i] == 0){
                first_row_zero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++){
            if(mat[i][0] == 0){
                Arrays.fill(mat[i], 0);
            }
        }

        for (int i = 1; i < n; i++){
            if(mat[0][i] == 0){
                for (int j = 0; j < m; j++){
                    mat[j][i] = 0;
                }
            }
        }

        if(first_row_zero){
            Arrays.fill(mat[0], 0);
        }

        if(first_col_zero){
            for (int i = 0; i < m; i++){ 
                mat[i][0] = 0;
            }
        }
    }
}


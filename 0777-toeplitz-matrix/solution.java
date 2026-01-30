class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int store = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int k = 0; k < m; k++){
            store = matrix[k][0];
            int i = k;
            int j = 0;
            while(j < n && i < m){
                if(matrix[i++][j++] != store)return false;
            }
        }

        for (int k = 0; k < n; k++){
            store = matrix[0][k];
            int i = k;
            int j = 0;
            while(j < m && i < n){
                if(matrix[j++][i++] != store)return false;
            }
        }
        return true;
    }
}

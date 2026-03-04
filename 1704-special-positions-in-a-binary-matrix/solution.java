class Solution {
    private boolean check(int[][] mat, int r, int c, int m, int n){
        int i = 0;
        while(i < m){
            if(mat[i][c] == 1 && i != r)return false;
            i++;
        }
        i = 0;
        while(i < n){
             if(mat[r][i] == 1 && i != c)return false;
            i++;
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(mat[i][j] == 1 && check(mat, i, j, m, n))cnt++;
            }
        }
        return cnt;
    }
}

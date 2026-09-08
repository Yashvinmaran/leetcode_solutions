class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Firstly calculate transporse means swap matrix diagonally

        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Then reverse the matrics rows
        for (int i = 0; i < n; i++){
            int j = 0;
            int k = n - 1;
            while(j < k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }
}

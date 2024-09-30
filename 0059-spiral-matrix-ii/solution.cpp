class Solution {
 public:
     vector<vector<int>> generateMatrix(int n) {
         vector<vector<int>> matrix(n, vector<int>(n, 0));
         int count = 1;
         int startRow = 0, endRow = n - 1;
         int startCol = 0, endCol = n - 1;
         while (startRow <= endRow && startCol <= endCol) {
             // Fill the top row
             for (int i = startCol; i <= endCol; i++) {
                 matrix[startRow][i] = count++;
             }
             startRow++;
             // Fill the right column
             for (int i = startRow; i <= endRow; i++) {
                 matrix[i][endCol] = count++;
             }
             endCol--;
             // Fill the bottom row
             if (startRow <= endRow) {
                 for (int i = endCol; i >= startCol; i--) {
                     matrix[endRow][i] = count++;
                 }
                 endRow--;
             }
             // Fill the left column
             if (startCol <= endCol) {
                 for (int i = endRow; i >= startRow; i--) {
                     matrix[i][startCol] = count++;
                 }
                 startCol++;
             }
         }
         return matrix;
     }
};

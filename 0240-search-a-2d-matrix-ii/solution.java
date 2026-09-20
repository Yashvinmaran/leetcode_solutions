class Solution {

    public static boolean searchMatrix(int[][] matrix, int target) {
 
        int row = 0, rows = matrix.length - 1, cols = matrix[0].length - 1;
        while(row <= rows && cols >= 0){
            int current = matrix[row][cols];
            if(current == target){
                return true;
            }else if(current > target){
                cols--;
            }else{
                row++;
            }
        }
        return false; 
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }
        int applyRow = 0;
        int up = 0;
        int down = matrix.length - 1;

        while (up <= down) {
            int mid = (up + down) >> 1;

            if (matrix[mid][0] <= target) {
                applyRow = mid;
                up = mid + 1;
            } else {
                down = mid - 1;
            }
        }

        int left = 0;
        int right = matrix[applyRow].length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[applyRow][mid] == target) {
                return true;
            } else if (matrix[applyRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}

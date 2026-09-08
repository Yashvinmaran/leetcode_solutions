class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while(top <= down && left <= right){
            for (int i = left; i <= right; i++){
                ans.add(mat[top][i]);
            }
            top++;

            for (int i = top; i <= down; i++){
                ans.add(mat[i][right]);
            }
            right--;

            // Guard condition for right-to-left traversal
            if (top <= down) {
                for (int i = right; i >= left; i--){
                    ans.add(mat[down][i]);
                }
                down--;
            }

            // Guard condition for bottom-to-top traversal
            if (left <= right) {
                for (int i = down; i >= top; i--){
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}


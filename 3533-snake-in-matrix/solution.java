class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] arr = new int[n][n];
        int c = 0;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                arr[i][j] = c++;
            }
        }
        int i = 0, j = 0;
        for (String s : commands){
            if(s.equals("UP")){
                i--;
            }else if(s.equals("RIGHT")){
               j++;
            }else if(s.equals("DOWN")){
                i++;
            }else {
                j--;
            }
        } 
        return arr[i][j];
    }
}

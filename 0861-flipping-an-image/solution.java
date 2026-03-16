class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                image[i][j] ^= 1;
            }
            int s = 0, e = n - 1;
            while(s < e){
                int temp = image[i][s];
                image[i][s] = image[i][e];
                image[i][e] = temp;
                s++; e--;
            }
        }
        return image;
    }
}

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int horizontal_max = 0;
        int vertical_max = 0;
        int count = 0;

        for (int i = 1; i < hBars.length; i++){
            if(hBars[i] - hBars[i - 1] == 1)count++;
            else count = 0;
            horizontal_max = Math.max(horizontal_max, count);
        }

        count = 0;
        for (int i = 1; i < vBars.length; i++){
            if(vBars[i] - vBars[i-1] == 1)count++;
            else count = 0;
            vertical_max = Math.max(vertical_max, count);
        }

        int side = Math.min(horizontal_max, vertical_max) + 2;

        return side * side;
    }
}

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, h = n-1;
        int maxArea = -1, area = 0;
        while(l<h){

            if(height[l]>height[h]){
                area = height[h]*(h-l);
                h--;
            }else{
                area = height[l]*(h-l);
                l++;
            }
           maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

class Solution {
    public int heightChecker(int[] heights) {
        int count=0;
        int[] heightfreq=new int[101];
        for(int h:heights){
            heightfreq[h]++;
        }
        int currheight=0;
        for(int i=0;i<heights.length;i++){
            while(heightfreq[currheight]==0){
                currheight++;
            }
            if(currheight!=heights[i]){
                count++;
            }
            heightfreq[currheight]--;
        }
        return count;
    }
}

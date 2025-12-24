class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total = 0;
        for (int a : apple){
            total += a;
        }
        int n = capacity.length;
        int fit = 0;
        
        int i = n-1;
        for (i = n-1; i >= 0; i--){
            fit += capacity[i];
            if(total <= fit)break;
        }
        return n-i;
    }
}

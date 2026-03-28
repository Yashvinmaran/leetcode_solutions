class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] acc : accounts){
            int sum = 0;
            for(int n : acc){
                sum += n;
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}

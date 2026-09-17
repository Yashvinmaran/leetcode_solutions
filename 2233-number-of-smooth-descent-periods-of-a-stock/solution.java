class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long totalCnt = prices.length;
        long cnt = 0;

        for (int i = 0; i < prices.length - 1; i++){
            if(prices[i] - prices[i+1] == 1)cnt++;
            else cnt = 0;
            totalCnt += cnt;
        }

        return totalCnt;
    }
}

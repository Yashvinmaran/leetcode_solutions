class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int c = 0;
        while(numBottles>=numExchange){
            int k = numBottles/numExchange;
            c += numExchange*k;
            numBottles -= numExchange*k;
            numBottles += k;
        }
        return c+numBottles;
    }
}

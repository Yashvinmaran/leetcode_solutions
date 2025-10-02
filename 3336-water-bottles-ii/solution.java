class Solution {
    public int maxBottlesDrunk(int numBottle, int numExchange) {
        int total = numBottle;
        int empty = numBottle;
        while (empty >= numExchange){
            empty -= numExchange;
            numExchange++;
            total++;
            empty++;
        }
        return total;
    }
}

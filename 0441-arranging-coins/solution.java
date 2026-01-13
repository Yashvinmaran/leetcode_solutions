class Solution {
    public int arrangeCoins(int n) {
        long sum = 0;
        int i = 1;
        for (; sum <= n; i++){
            sum += i;
        }
        return (i - 2);
    }
}

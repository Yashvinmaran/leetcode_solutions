class Solution {
    public boolean isPerfectSquare(int num) {
        double p = Math.pow(num, 0.5);
        int power = (int)p;
        return Math.pow(power,2) == num;
    }
}

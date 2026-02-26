import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int cnt = 0;
        BigInteger one = BigInteger.ONE;
        BigInteger zero = BigInteger.ZERO;
        BigInteger two = BigInteger.valueOf(2);

        while (num.compareTo(one) > 0) {
            if (!num.remainder(two).equals(zero)) {
                num = num.add(one);
            } else {
                num = num.divide(two);
            }
            cnt++;
        }
        return cnt;
    }
}


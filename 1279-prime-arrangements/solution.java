class Solution {
    static final long MOD = 1_000_000_007;
    static long factorial(int n) {
        long fact =1;
        for (int i= 1;i <= n; i++) {
            fact=(fact * i) % MOD;
        }
        return fact;
    }
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public int numPrimeArrangements(int n) {
        int p = 0;
        for (int i = 2;i <= n; i++) {
            if (isPrime(i)) {
                p++;
            }
        }
        long ans = (factorial(p)*factorial(n-p))%MOD;
        return (int) ans;
    }
}

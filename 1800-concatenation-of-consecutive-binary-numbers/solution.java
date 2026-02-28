class Solution {
    public int concatenatedBinary(int n) {
        long mod = 1_000_000_007;
        long ans = 0;
        int shift = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                shift++;
            }
            ans = ((ans << shift) + i) % mod;
        }

        return (int) ans;
    }
}


class Solution {
    static final int MOD = 1_000_000_007;
    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Build powers array from bits of n
        java.util.List<Integer> powersList = new java.util.ArrayList<>();
        int bit = 0;
        int temp = n;
        while (temp > 0) {
            if ((temp & 1) == 1) {
                powersList.add(1 << bit);
            }
            bit++;
            temp >>= 1;
        }
        java.util.Collections.sort(powersList);

        int m = powersList.size();
        long[] prefixProd = new long[m];
        prefixProd[0] = powersList.get(0) % MOD;
        for (int i = 1; i < m; i++) {
            prefixProd[i] = (prefixProd[i - 1] * powersList.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long product;
            if (l == 0) {
                product = prefixProd[r];
            } else {
                long numerator = prefixProd[r];
                long denominatorInverse = modPow(prefixProd[l - 1], MOD - 2);
                product = (numerator * denominatorInverse) % MOD;
            }
            ans[i] = (int) product;
        }
        return ans;
    }
}


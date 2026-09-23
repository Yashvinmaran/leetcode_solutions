class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        int mod = 1_000_000_007; 

        int pow = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                list.add(pow);
            }
            pow <<= 1;
            n >>= 1;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long product = 1;

            while (left <= right) {
                product = (product * list.get(left)) % mod;
                left++;
            }
            ans[i] = (int) product;
        }

        return ans;
    }
}


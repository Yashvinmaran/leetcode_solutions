class Solution {
    // Predefined GCD array matching the C++ constexpr matrix
    private static final int[][] GCD = {
        {}, 
        {1}, 
        {2, 1}, 
        {3, 1, 1}, 
        {4, 1, 2, 1}, 
        {5, 1, 1, 1, 1}, 
        {6, 1, 2, 3, 2, 1}, 
        {7, 1, 1, 1, 1, 1, 1}, 
        {8, 1, 2, 1, 4, 1, 2, 1}, 
        {9, 1, 1, 3, 1, 1, 3, 1, 1}
    };

    public String smallestNumber(String num, long t) {
        // Long.numberOfTrailingZeros acts as the equivalent to __builtin_ctzll
        long temp = t >> Long.numberOfTrailingZeros(t);
        for (int i : new int[]{3, 5, 7}) {
            while (temp % i == 0) {
                temp /= i;
            }
        }
        if (temp > 1) return "-1";

        int n = num.length();
        long[] rem = new long[n + 1];
        char[] s = num.toCharArray(); // Convert to char array since Java Strings are immutable
        
        rem[0] = t;
        rem[n] = 0;
        int pos = n - 1;

        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                pos = i;
                break;
            }
            int digit = s[i] - '0';
            rem[i + 1] = rem[i] / GCD[digit][(int) (rem[i] % digit)];
        }

        if (rem[n] == 1) return num;

        for (int i = pos; i >= 0; i--) {
            while (true) {
                s[i]++;
                if (s[i] > '9') break;

                int digit = s[i] - '0';
                long curr = rem[i] / GCD[digit][(int) (rem[i] % digit)];
                int k = 9;
                
                for (int j = n - 1; j > i; j--) {
                    while (curr % k != 0) {
                        k--;
                    }
                    curr /= k;
                    s[j] = (char) ('0' + k);
                }
                if (curr == 1) return new String(s);
            }
        }

        // Fallback buffer logic
        int maxN = 200001;
        char[] buf = new char[maxN + 2];
        int p = maxN + 1;

        for (int i = 9; i > 1; i--) {
            while (t % i == 0) {
                buf[--p] = (char) (i + '0');
                t /= i;
            }
        }
        
        while (maxN - p < n) {
            buf[--p] = '1';
        }

        return new String(buf, p, maxN + 1 - p);
    }
}


import java.util.*;

class Solution {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return count(finish, limit, s) - count(start - 1, limit, s);
    }

    private long count(long upperBound, int limit, String s) {
        String upperStr = String.valueOf(upperBound);
        int n = upperStr.length();
        int m = s.length();
        if (n < m) return 0;

        Map<String, Long> memo = new HashMap<>();
        return dp(0, true, upperStr, s, limit, memo);
    }

    private long dp(int index, boolean tight, String upperStr, String suffix, int limit, Map<String, Long> memo) {
        if (index == upperStr.length()) {
            return 1;
        }

        String key = index + "," + tight;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long count = 0;
        int upper = tight ? upperStr.charAt(index) - '0' : limit;
        int n = upperStr.length();
        int m = suffix.length();

        for (int digit = 0; digit <= upper; digit++) {
            if (digit > limit) continue;

            boolean newTight = tight && (digit == upper);

            if (n - index <= m) {
                if (n - index == m) {
                    if (digit == suffix.charAt(index - (n - m)) - '0') {
                        count += dp(index + 1, newTight, upperStr, suffix, limit, memo);
                    }
                } else {
                    if (digit == suffix.charAt(index - (n - m)) - '0') {
                        count += dp(index + 1, newTight, upperStr, suffix, limit, memo);
                    }
                }
            } else {
                count += dp(index + 1, newTight, upperStr, suffix, limit, memo);
            }
        }

        memo.put(key, count);
        return count;
    }
}

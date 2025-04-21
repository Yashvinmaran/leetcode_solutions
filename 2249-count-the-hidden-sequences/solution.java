public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long curr = 0;
        long minPrefix = 0;
        long maxPrefix = 0;

        for (int diff : differences) {
            curr += diff;
            minPrefix = Math.min(minPrefix, curr);
            maxPrefix = Math.max(maxPrefix, curr);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        return (int) Math.max(0, maxStart - minStart + 1);
    }
}


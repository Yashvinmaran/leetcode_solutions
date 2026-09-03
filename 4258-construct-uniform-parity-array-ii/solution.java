class Solution {
    public boolean uniformArray(int[] nums) {
        final int inf = Integer.MAX_VALUE;
        int minOdd = inf;

        for (int x : nums) {
            if (x % 2 != 0) {
                minOdd = Math.min(minOdd, x);
            }
        }

        for (int x : nums) {
            if (x % 2 == 0 && minOdd != inf && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}


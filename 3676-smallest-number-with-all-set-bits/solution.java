class Solution {
    public int smallestNumber(int n) {
        int res = 0, p = 1;
        while (res < n) {
            res += p;
            p <<= 1; // multiply by 2
        }
        return res;
    }
}


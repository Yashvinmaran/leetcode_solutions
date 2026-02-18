class Solution {
    public boolean hasAlternatingBits(int n) {
        int bit = n ^ (n >> 1);
        return (bit & (bit + 1)) == 0;
    }
}

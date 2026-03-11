class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)return 1;
        int bit = 1;
        while(bit <= n){
            n ^= bit;
            bit <<= 1;
        }
        return n;
    }
}

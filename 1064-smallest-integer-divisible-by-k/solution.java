class Solution {
    public int smallestRepunitDivByK(int k) {
        if((k&1) == 0 || k%5 == 0)return -1;
        if(k == 1)return 1;
        int rem = 1;
        for (int len = 2;; len++){
            rem = (rem * 10 + 1)%k;
            if(rem == 0)return len;
        }
    }
}

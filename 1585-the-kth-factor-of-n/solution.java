class Solution {
    public int kthFactor(int n, int k) {
        int fac = -1;
        for (int i = 1; i<=n && k>0; i++){
            if(n % i == 0){
                fac = i;
                k--;
            }
        }
        if(k == 0)return fac;
        return -1;
    }
}

class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int m1 = n/2-1;
        int ne = -(n/2);
        int m = n % 2 == 0 ? 0 : -1;
        for (int i = 0; i<n; i++){
            ans[i] = ne;
            ne++;
            if(m==0 && i==m1 )ne++;
        }
        return ans;
    }
}

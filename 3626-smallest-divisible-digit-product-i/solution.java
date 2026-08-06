class Solution {

    private static int prod(int n){
        int pro = 1;

        while(n != 0){
            pro *= n%10;
            n /= 10;
        }

        return pro;
    }

    public int smallestNumber(int n, int t) {
        
        for (int i = n; i <= 100; i++){
            int product = prod(i);
            if(product % t == 0)return i;
        }

        return n;
    }
}

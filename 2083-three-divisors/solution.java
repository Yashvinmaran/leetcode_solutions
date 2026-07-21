class Solution {
    public boolean isThree(int n) {
        
        int count = 0;

        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; 
                
                if (i != n / i) {
                    count++;
                }
            }
        }

        return count==3;
    }
}

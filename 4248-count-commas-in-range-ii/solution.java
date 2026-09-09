class Solution {
    public long countCommas(long n) {
        long count = 0;

        long num = 1000;

       while(num <= n){
        count += (n - num + 1);
        num *= 1000;
       }

        return count;
    }
}

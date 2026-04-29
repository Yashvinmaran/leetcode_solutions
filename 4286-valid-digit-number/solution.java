class Solution {
    public boolean validDigit(int n, int x) {
        boolean first = true, occurence = false;
        while(n > 0){
            int digit = n % 10;
            if(digit == x)occurence = true;
            if(n < 10 && digit == x) return false;
            n /= 10;
        }

        return occurence;
    }
}

class Solution {
    public int reverse(int x) {
        int rev = 0;
        for (;x != 0; x = x/10){
            int digit = x%10;
            if (rev < (Integer.MIN_VALUE/10) || rev > (Integer.MAX_VALUE/10)){
                return 0;
            }
            rev = rev * 10 + digit;
        }
        return rev;
    }
}

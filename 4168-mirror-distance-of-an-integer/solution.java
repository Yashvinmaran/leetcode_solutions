class Solution {
    private int reverse(int x) {
    int rev = 0;
    while (x != 0) {
        int pop = x % 10;
        x /= 10;
        
        // Overflow check: If next step exceeds 2,147,483,647 (Integer.MAX_VALUE)
        if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
        // Underflow check: If next step goes below -2,147,483,648 (Integer.MIN_VALUE)
        if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
        
        rev = rev * 10 + pop;
    }
    return rev;
}

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
}

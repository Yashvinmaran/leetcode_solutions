class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm((long) a, (long) b);
        long ac = lcm((long) a, (long) c);
        long bc = lcm((long) b, (long) c);
        long abc = lcm(ab, (long) c);
        
        long low = 1;
        long high = 2_000_000_000; // Maximum possible answer according to constraints
        long ans = low;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            // Inclusion-Exclusion Principle
            long count = (mid / a) + (mid / b) + (mid / c) 
                       - (mid / ab) - (mid / ac) - (mid / bc) 
                       + (mid / abc);
            
            if (count >= n) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid number
            } else {
                low = mid + 1;
            }
        }
        
        return (int) ans;
    }
    
    // Helper method to calculate Greatest Common Divisor (GCD)
    private long gcd(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
    
    // Helper method to calculate Least Common Multiple (LCM)
    private long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }
}


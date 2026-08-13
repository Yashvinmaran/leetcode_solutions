class Solution {
    private static int calculate(int num) {
        boolean hasInvalid = false;
        boolean hasValidRotation = false;

        while (num != 0) {
            int digit = num % 10;
            
            for (int n : new int[]{3, 4, 7}) {
                if (digit == n) {
                    hasInvalid = true;
                }
            }
            
            for (int n : new int[]{2, 5, 6, 9}) {
                if (digit == n) {
                    hasValidRotation = true;
                }
            }
            
            num /= 10;
        }
        
        return (!hasInvalid && hasValidRotation) ? 1 : 0;
    }

    public int rotatedDigits(int n) {
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            cnt += calculate(i);
        }
        return cnt;
    }
}


class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            int sum = n + 1;
            int cnt = 2;
            int tempDivisor = 0;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    if (i * i != n) {
                        cnt += 2;
                        sum += i + (n / i);
                    } else {
                        cnt += 1;
                        sum += i;
                    }
                }
            }
            if (cnt == 4) {
                totalSum += sum;
            }
        }
        return totalSum;
    }
}


class Solution {

    private int waviness(int num) {
        int cnt = 0;

        while (num >= 100) {
            int a = num % 10; 
            int b = (num / 10) % 10; 
            int c = (num / 100) % 10; 

            if ((b > a && b > c) || (b < a && b < c)) {
                cnt++;
            }

            num /= 10; 
        }
        return cnt;
    }

    public int totalWaviness(int num1, int num2) {
        int cnt = 0;
        for (int n = num1; n <= num2; n++) {
            cnt += waviness(n);
        }

        return cnt;
    }
}

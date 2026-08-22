class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int digitSum = 0;
        int digitProduct = 1;

        while(num != 0){
            digitSum += num % 10;
            digitProduct *= num % 10;
            num /= 10;
        }

        return (n % (digitProduct + digitSum) == 0);
    }
}

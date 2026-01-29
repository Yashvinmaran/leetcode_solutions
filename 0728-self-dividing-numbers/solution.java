class Solution {
    private static boolean isSelfDividing(int num){
        if(num <= 9)return true;

        int digit = 0;
        int n = num;
        while(n > 0){
            digit = n % 10;
            if(digit == 0)return false;
            if(num % digit != 0)return false;
            n /= 10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++){
            if(isSelfDividing(i))ans.add(i);
        }
        return ans;
    }
}

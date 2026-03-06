class Solution {
    public boolean checkZeroOnes(String s) {
        int cnt_zero = 0;
        int cnt_one = 0;
        int max1 = 0, max2 = 0;

        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt_one++;
                max1 = Math.max(cnt_one, max1);
                cnt_zero = 0;
            }else{
                cnt_zero++;
                max2 = Math.max(cnt_zero, max2);
                cnt_one = 0;
            }
        }
        return max1 > max2;
    }
}

class Solution {
    public String convertToBase7(int n) {
        if(n == 0)return "0";
        boolean isNegetive = (n<0);
        int num = Math.abs(n);

        StringBuilder sb = new StringBuilder();

        while(num > 0){
            int rem = num%7;
            sb.append(rem);
            num /= 7;
        }
        if(isNegetive)sb.append('-');
        return sb.reverse().toString();
    }
}

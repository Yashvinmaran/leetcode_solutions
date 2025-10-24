class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            int num = c - 'a' + 1;
            sb.append(num);
        }
         int sum = 0;
        for (int i = 0; i<sb.length(); i++){
            sum += (sb.charAt(i) - '0');
        }
        while(k-- > 1){
           int digit = 0;
           while(sum != 0){
            digit += sum%10;
            sum /= 10;
           }
           sum = digit;
        }
        return sum;
    }
}

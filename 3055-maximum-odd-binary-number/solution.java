class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int left = 0;
        int right = n-1;
        while(left<= right){
            if(str[left] == '1') left++;
            if(str[right] == '0') right--;

            if(left <= right && str[left] == '0' && str[right]== '1'){
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
            }
        }
        char temp = str[left-1];
        str[left-1] = str[n-1];
        str[n-1] = temp;

        return new String(str);
    }
}

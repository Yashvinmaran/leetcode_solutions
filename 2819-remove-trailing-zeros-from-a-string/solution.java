class Solution {
    public String removeTrailingZeros(String num) {
        int i=num.length()-1;
        while(i >= 0)
        {
            if(num.charAt(i)!='0')
            {
                break;
            }
            i--;
        }
        return num.substring(0,i+1);
    }
}

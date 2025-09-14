class Solution {
    public boolean checkRecord(String s) {
        int count = 0;
        int absent = 0;
        for (char c : s.toCharArray()){
            if(c == 'A')absent++;
            if(c != 'L'){
                count = 0;
            }else if(c == 'L')count++;
            if(c == 3)return false;
            if((absent >= 2) || (count >= 3))return false;
        }
        return true;
    }
}

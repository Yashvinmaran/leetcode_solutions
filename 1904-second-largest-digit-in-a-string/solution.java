class Solution {
    public int secondHighest(String s) {
        int maxi1 = -1;
        int maxi2 = -1;
       for (char c : s.toCharArray()){
        if(Character.isDigit(c)){
            int n = c - '0';
            maxi1 = Math.max(maxi1,n);
        }
       }
       for (char c : s.toCharArray()){
        if(Character.isDigit(c)){
            int n = c - '0';
            if(n < maxi1 && n > maxi2)maxi2 = n;
        }
       }
       return maxi2;
    }
}

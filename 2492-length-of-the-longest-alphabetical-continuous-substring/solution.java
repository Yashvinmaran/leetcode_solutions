class Solution {
    public int longestContinuousSubstring(String s) {
        int c = 1;
        int maxi=1;
       for (int i = 1; i < s.length(); i++){
        if((s.charAt(i) - s.charAt(i - 1)) == 1){
            c++;
            maxi = Math.max(maxi,c);
        }else{
            c = 1;
        }
       }
       return maxi;
    }
}

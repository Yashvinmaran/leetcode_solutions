class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        boolean[] dp = new boolean[m];
        Arrays.fill(dp,false);
        char[] arr = new char[n];
        arr = t.toCharArray();
        int i = 0;
        int j = 0;
        while(j<n && i<m){
        char c = s.charAt(i);
            if(c == arr[j]){
                dp[i++] = true; 
                j++; 
            }else{
                j++;
            }
        }
        for (boolean f : dp){
            if(!f)return false;
        }
        return true;
    }
}

class Solution {
    private String invert(String s){
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++){
        if(arr[i] == '0') arr[i] = '1';
        else arr[i] = '0';
    }
    int i = 0, j = arr.length - 1;
    while(i < j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        i++; j--;
    }
    return new String(arr); 
}

    private String helper(int n, String s, String[] dp){
        if(n == 1)return "0";
        if(dp[n] != null)return dp[n];
        return dp[n] = (helper(n - 1, s, dp) + "1" + invert(helper(n - 1, s, dp)));
    }
    public char findKthBit(int n, int k) {
        String[] dp = new String[n + 1];
        Arrays.fill(dp,null);
        String s = new String((helper(n, "", dp)));

        return s.charAt(k - 1);
    }
}

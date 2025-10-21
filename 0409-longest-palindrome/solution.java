class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        boolean isOdd = false;
        int res = 0;

        for (char c : s.toCharArray()){
            arr[c]++;
        }
        for (int count : arr){
            if(count%2 == 0){
                res += count;
            }else{
                isOdd = true;
                res += count - 1;
            }
        }
        if(isOdd){
            res += 1;
        }
        return res;
    }
}

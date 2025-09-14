class Solution {
    public boolean isPalindromic(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i++) != str.charAt(j--))return false;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for (String str : words){
            if(isPalindromic(str))return str;
        }
        return "";
    }
}

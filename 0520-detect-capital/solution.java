class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        boolean flag = false;
        if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')flag = true;
        for (char c : word.toCharArray()){
            if(c >= 'A' && c <='Z')cnt++;
        }
        if(cnt == word.length() || (flag && cnt == 1) || cnt == 0)return true;
        return false;
    }
}

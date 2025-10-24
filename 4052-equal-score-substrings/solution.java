class Solution {
    public boolean scoreBalance(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray())left += c - 'a' + 1;
        for (char c : s.toCharArray()){
            right += c - 'a' + 1;
            if(right*2 == left)return true;
        }
        return false;
    }
}

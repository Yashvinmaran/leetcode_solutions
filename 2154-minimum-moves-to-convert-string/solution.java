class Solution {
    public int minimumMoves(String s) {
        int cnt = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                cnt++;
                i += 3; 
            } else {
                i++;
            }
        }
        return cnt;
    }
}


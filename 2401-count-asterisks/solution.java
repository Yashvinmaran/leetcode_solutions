class Solution {
    public int countAsterisks(String s) {
        int cnt = 0;
        boolean flag = true;
        for (char c : s.toCharArray()){
            if(flag && c == '*')cnt++;
            else if(flag && c == '|')flag = false;
            else if(!flag && c == '|')flag = true;
        }
        return cnt;
    }
}

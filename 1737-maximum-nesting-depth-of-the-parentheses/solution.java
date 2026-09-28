class Solution {
    public int maxDepth(String s) {
        
        int cnt = 0;
        int maxCnt = 0;

        for (char c : s.toCharArray()){
            if(c == '('){
                cnt++;
            }else if(c == ')') cnt--;
            maxCnt = Math.max(cnt, maxCnt);
        }

        return maxCnt;
    }
}

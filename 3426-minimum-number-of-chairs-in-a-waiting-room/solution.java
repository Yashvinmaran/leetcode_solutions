class Solution {
    public int minimumChairs(String s) {
        int minRequired = 0;
        int cnt = 0;

        for (char c : s.toCharArray()){
            if(c == 'E'){
                cnt++;
            }else{
                cnt--;
            }
            minRequired = Math.max(cnt, minRequired);
        }
        return minRequired;
    }
}

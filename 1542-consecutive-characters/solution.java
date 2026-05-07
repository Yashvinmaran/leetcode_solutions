class Solution {
    public int maxPower(String s) {
        
        int cnt = 1;
        int max = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                cnt++;
            } else {
                cnt = 1;
            }
            max = Math.max(cnt, max); 
        }
        
        return max; 
    }
}


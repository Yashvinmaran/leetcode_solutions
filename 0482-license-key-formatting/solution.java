class Solution {
    public String licenseKeyFormatting(String str, int k) {
        String s = str.replace("-", "").toUpperCase();
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            cnt++;
            
            if (cnt == k && i != 0) {
                sb.append('-');
                cnt = 0;
            }
        }
        
        return sb.reverse().toString();
    }
}


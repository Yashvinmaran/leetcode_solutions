class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int c = k;

        for (int i = 0; i<n; i++){
            int idx = (i + k) % n;
            sb.append(s.charAt(idx));
        }
        return sb.toString();
    }
}

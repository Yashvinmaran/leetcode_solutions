class Solution {
    public boolean checkInclusion(String p, String s) {
        int m = p.length(), n = s.length();
        if (m > n) return false;

        int[] countP = new int[26];
        int[] countWindow = new int[26];

        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            countWindow[s.charAt(i) - 'a']++;
        }

        if (matches(countP, countWindow)) return true;

        for (int i = m; i < n; i++) {
            countWindow[s.charAt(i) - 'a']++;             
            countWindow[s.charAt(i - m) - 'a']--;         

            if (matches(countP, countWindow)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}


class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return 0;
        if (n < m) return -1;

        int[] lps = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                    i--;
                } else {
                    lps[i] = 0;
                }
            }
        }

        j = 0;
        for (int i = 0; i < n; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == m) return i - m + 1;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                    i--;
                }
            }
        }
        return -1;
    }
}


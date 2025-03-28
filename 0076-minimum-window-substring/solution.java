class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] target = new int[128];
        for (char c : t.toCharArray()) {
            target[c]++;
        }

        int i = 0, j = 0, minLen = Integer.MAX_VALUE, start = 0;
        int count = t.length();

        while (j < s.length()) {
            if (target[s.charAt(j)] > 0) {
                count--;
            }
            target[s.charAt(j)]--;
            j++;

            while (count == 0) {
                if (j - i < minLen) {
                    minLen = j - i;
                    start = i;
                }
                target[s.charAt(i)]++;
                if (target[s.charAt(i)] > 0) {
                    count++;
                }
                i++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}


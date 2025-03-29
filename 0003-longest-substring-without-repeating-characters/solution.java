public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);
            if (!seen.contains(c)) {
                seen.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}


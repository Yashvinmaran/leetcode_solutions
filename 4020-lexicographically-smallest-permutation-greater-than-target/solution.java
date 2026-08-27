class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] counts = new int[26];
        
        // Count frequencies of each character in s
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        // Step 1: Attempt to build an exact match of target character-by-character
        int matchLen = 0;
        while (matchLen < n) {
            int idx = target.charAt(matchLen) - 'a';
            if (counts[idx] > 0) {
                counts[idx]--;
                matchLen++;
            } else {
                break;
            }
        }
        
        // Step 2: Backtrack from the longest matched prefix to find the rightmost pivot point
        for (int i = matchLen; i >= 0; i--) {
            // If we are backtracking, we must restore the character we skipped
            if (i < matchLen) {
                counts[target.charAt(i) - 'a']++;
            }
            
            // We cannot deviate past the end of the string length
            if (i == n) continue;
            
            // Try to find a character strictly greater than target.charAt(i)
            int targetCharIdx = target.charAt(i) - 'a';
            for (int c = targetCharIdx + 1; c < 26; c++) {
                if (counts[c] > 0) {
                    // Found a valid larger character! Build the final answer string
                    StringBuilder sb = new StringBuilder();
                    
                    // 1. Add identical prefix match
                    sb.append(target.substring(0, i));
                    
                    // 2. Add the strictly greater character
                    sb.append((char) ('a' + c));
                    counts[c]--;
                    
                    // 3. Add all remaining characters in smallest sorted order
                    for (int rem = 0; rem < 26; rem++) {
                        while (counts[rem] > 0) {
                            sb.append((char) ('a' + rem));
                            counts[rem]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }
        
        // If no valid deviation point could be found, return empty string
        return "";
    }
}


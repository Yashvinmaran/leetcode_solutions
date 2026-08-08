class Solution {
    public int[] validSequence(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        // suffix[j] will store the rightmost index in word1 
        // that can match the remaining suffix of word2 starting from index j.
        int[] suffix = new int[n2];
        Arrays.fill(suffix, -1);
        
        // Step 1: Pre-calculate rightmost matches from the back
        int j = n2 - 1;
        for (int i = n1 - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                suffix[j] = i;
                j--;
            }
        }
        
        int[] ans = new int[n2];
        boolean canUse = true; // Tracks if the 1-character alteration is still available
        
        // Step 2: Greedy approach from the front to get the lexicographically smallest sequence
        j = 0;
        for (int i = 0; i < n1 && j < n2; i++) {
            // Case 1: The characters match naturally
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } 
            // Case 2: Characters do not match, but we have our 1 wildcard modification left
            // We check if the remaining suffix of word2 (j + 1) can be completely matched 
            // strictly after our current position 'i' in word1.
            else if (canUse && (j == n2 - 1 || suffix[j + 1] > i)) {
                ans[j] = i; // Consume wildcard to force a match here
                canUse = false; // Wildcard used up
                j++;
            }
        }
        
        // If we successfully found indices for all characters of word2, return the sequence.
        // Otherwise, it's impossible, so return an empty array.
        return j == n2 ? ans : new int[0];
    }
}


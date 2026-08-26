class Solution { 
    public String shortestBeautifulSubstring(String s, int k) { 
        int n = s.length(); 
        int small = n + 1; // Start greater than any possible length
        int cnt = 0; 
        int left = 0; 
        String ans = ""; 
        
        for (int right = 0; right < n; right++){ 
            char c = s.charAt(right); 
            cnt += c == '1' ? 1 : 0; 
            
            // Shrink from the left as long as the window is valid (cnt == k)
            while (cnt == k) {
                int currLen = (right - left + 1); 
                String currStr = s.substring(left, right + 1);
                
                // Fix 1: Check for shorter length OR equal length but lexicographically smaller
                if (currLen < small || (currLen == small && currStr.compareTo(ans) < 0)) { 
                    ans = currStr; 
                    small = currLen; 
                } 
                
                // Fix 2: Move left pointer inside the validity check to look for smaller windows
                char lc = s.charAt(left); 
                cnt -= lc == '1' ? 1 : 0; 
                left++; 
            } 
        } 
        return ans; 
    } 
}


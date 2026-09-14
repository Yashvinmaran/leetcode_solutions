class Solution { 
    public String minWindow(String s, String t) { 
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128]; 
        int cnt = 0; 
        
        for (int i = 0; i < t.length(); i++) { 
            char c = t.charAt(i);
            if (map[c] == 0) {
                cnt++; 
            }
            map[c]++; 
        } 
        
        int minLen = Integer.MAX_VALUE; 
        int left = 0; 
        int startIdx = 0; 
        boolean found = false;

        for (int right = 0; right < s.length(); right++) { 
            char rChar = s.charAt(right);
            
            map[rChar]--; 
            
            if (map[rChar] == 0) { 
                cnt--; 
            } 
            
            while (cnt == 0) { 
                found = true;
                int currLen = (right - left + 1); 
                if (minLen > currLen) { 
                    minLen = currLen; 
                    startIdx = left;
                } 
                
                char lChar = s.charAt(left);
                map[lChar]++; 
                
                if (map[lChar] > 0) { 
                    cnt++; 
                } 
                left++; 
            } 
        } 
        
        return found ? s.substring(startIdx, startIdx + minLen) : ""; 
    } 
}


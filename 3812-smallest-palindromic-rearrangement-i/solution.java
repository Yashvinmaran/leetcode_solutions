class Solution { 
    public String smallestPalindrome(String s) { 

        int n = s.length(); 
        int[] freq = new int[26]; 
        for (char c : s.toCharArray()){ 
            freq[c - 'a']++; 
        } 
        
        StringBuilder sb = new StringBuilder(); 
        char c = 'a'; 
        for (int i = 0; i < 26; i++){ 
            int half_freq = freq[i]/2; 
            for (int j = 0; j < half_freq; j++){ 
                sb.append(c); 
            } 
            freq[i] = freq[i] % 2; 
            c++; 
        } 
        
        c = 'a'; 
        for (int i = 0; i < 26; i++, c = (char)('a' + i)){ 
            if(freq[i] != 0){ 
                sb.append(c); 
                break; 
            } 
        } 
        
        int half = n % 2 == 0 ? sb.length() - 1 : sb.length() - 2; 
        for (int i = half; i >= 0; i--){ 
            sb.append(sb.charAt(i)); 
        } 
        return sb.toString(); 
    } 
}


class Solution { 
    public String reorganizeString(String s) { 
        int n = s.length();
        if (n <= 1) return s; 
        
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(counts[b], counts[a])); 
        
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                if (counts[i] > (n + 1) / 2) return ""; 
                pq.add(i); 
            }
        } 
        
        StringBuilder sb = new StringBuilder(); 
        
        while (pq.size() >= 2) { 
            int charIdx1 = pq.poll(); 
            int charIdx2 = pq.poll(); 
            
            sb.append((char) (charIdx1 + 'a')); 
            sb.append((char) (charIdx2 + 'a')); 
            
            counts[charIdx1]--; 
            counts[charIdx2]--; 
            
            if (counts[charIdx1] > 0) pq.add(charIdx1); 
            if (counts[charIdx2] > 0) pq.add(charIdx2); 
        } 
        
        if (!pq.isEmpty()) {
            sb.append((char) (pq.poll() + 'a'));
        }
        
        return sb.toString(); 
    } 
}


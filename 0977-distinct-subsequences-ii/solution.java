class Solution { 
    public int distinctSubseqII(String s) { 
        int mod = 1_000_000_007; 
        int n = s.length(); 
        long total = 0; 
        int[] prev = new int[26]; 
        
        for (int i = 0; i < n; i++){ 
            int idx = s.charAt(i) - 'a'; 
            long current_added = (total + 1) % mod;
            long new_total = (total + current_added) % mod; 
            
            long duplicate = prev[idx];
            long next_total = (new_total - duplicate + mod) % mod;
            
            prev[idx] = (int) current_added;
            total = next_total;
        } 
        return (int) total; 
    } 
}


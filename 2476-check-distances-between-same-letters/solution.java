class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ind = 0;
            if(set.contains(c)) {
                continue;
            }
            for(int j = i+1; j < s.length(); j++){ 
                if(s.charAt(j) == c) {
                    ind = j;
                }
            }
            set.add(c);
            if(ind-i-1 != distance[c - 'a']){ 
                return false;
            }
        }
        return true;
    }
}


class Solution {
    public int maximumLengthSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            if(map.get(s.charAt(right)) > 2){
                while((map.get(s.charAt(right)) > 2)){
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
            }maxLen = Math.max(maxLen, (right - left + 1));
        }

        return maxLen;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c : p.toCharArray()){
            freq1[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            freq2[s.charAt(right) - 'a']++;
            while(freq1[s.charAt(right) - 'a'] < freq2[s.charAt(right) - 'a']){
                freq2[s.charAt(left) - 'a']--;
                left++;
            }

            if((right - left + 1) == p.length())ans.add(left);
        }

        return ans;
    }
}

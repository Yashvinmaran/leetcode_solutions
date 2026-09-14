class Solution {

    private static boolean compare(String s1, String s2, int[] freq){

        int[] freq2 = new int[26];

        for (char s : s2.toCharArray()){
            freq2[s-'a']++;
        }

        for (int i = 0; i < 26; i++){
            if(freq[i] != freq2[i])return false;
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
    
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char s : s1.toCharArray()){
            freq1[s-'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++){
            freq2[s2.charAt(right) - 'a']++;
            while(freq1[s2.charAt(right) - 'a'] < freq2[s2.charAt(right) - 'a']){
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }
            if((right - left + 1) == s1.length())return true;
        }

        return false;
    }
}

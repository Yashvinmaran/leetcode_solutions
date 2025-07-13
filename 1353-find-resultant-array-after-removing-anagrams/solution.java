class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
    int i = 0, j = 1;
    public List<String> removeAnagrams(String[] words) {
        int l = words.length;
        List<String>list = new ArrayList<>();
        list.add(words[0]);
        while(i < l && j < l){
            if(isAnagram(words[i],words[j]))j++;
            else{
                i = j;
                list.add(words[i]);
            }
        }
        return list;
    }
}

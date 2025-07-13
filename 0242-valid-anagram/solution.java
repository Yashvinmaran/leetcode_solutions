class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int size = s.length();
        int[] arr = new int[26];
        for (int i = 0; i<size; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i<26; i++)if(arr[i] != 0)return false;
        return true;
    }
}

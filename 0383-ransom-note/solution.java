class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int n1 = ransomNote.length();
        int n2 = magazine.length();
        for (int i = 0; i<n1; i++){
            char a = ransomNote.charAt(i);
            arr[a - 'a'] += 1;
        }

        for (int i = 0; i<n2; i++){
            char b = magazine.charAt(i);
            if(arr[b - 'a'] > 0)arr[b - 'a'] -= 1;
        }
        
        
        for (int i = 0; i<26; i++)if(arr[i] != 0)return false;
        return true;
    }
}

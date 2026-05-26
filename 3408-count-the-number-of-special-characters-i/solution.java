class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        boolean[] small = new boolean[26];
        boolean[] capital = new boolean[26];

        for (char ch : word.toCharArray()){
            if(ch > 'Z'){
                small[ch - 97] = true;
            }else capital[ch - 65] = true;
        }

        int cnt = 0;
        for(int i = 0; i < 26; i++){
            if(small[i] && capital[i])cnt++;
        }

        return cnt;
    }
}

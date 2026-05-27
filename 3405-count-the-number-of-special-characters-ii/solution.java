class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLowercase = new int[26];
        int[] firstUppercase = new int[26];
        
        Arrays.fill(lastLowercase, -1);
        Arrays.fill(firstUppercase, -1);
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lastLowercase[ch - 'a'] = i;
            } else if (ch >= 'A' && ch <= 'Z') {
                int index = ch - 'A';
                if (firstUppercase[index] == -1) {
                    firstUppercase[index] = i;
                }
            }
        }
        
        int specialCount = 0;
        

        for (int i = 0; i < 26; i++) {
            if (lastLowercase[i] != -1 && firstUppercase[i] != -1 && lastLowercase[i] < firstUppercase[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}


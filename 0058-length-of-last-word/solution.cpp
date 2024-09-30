 class Solution {
 public:
     int lengthOfLastWord(string s) {
         int len = 0;
         bool inWord = false;
         for (int i = s.size() - 1; i >= 0; i--) {
             if (s[i] != ' ') {
                 len++;
                 inWord = true;
             } else if (inWord) {
                 break;
             }
         }
         return len;
     }
};

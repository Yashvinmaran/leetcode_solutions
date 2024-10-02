 class Solution {
 public:
     int lengthOfLastWord(string s) {
        int length = 0;
        bool inword = false;
        for (int i = s.length()-1; i>=0; i--){
            if (s[i] != ' '){
                length ++;
                inword = true;
            }else if(inword){
                break;
            }
        }
        return length;
     }
};

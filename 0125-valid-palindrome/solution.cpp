/*class Solution {
public:
    bool isPalindrome(string s) {
        string news = "";
        for (char p:s){
            if(p >= 'A' && p<='z'){
                if(p >= 'A' && p <= 'Z'){
                    p = p+32;
                }
                news += p;
            }
        }
        int i = 0;
        int j = news.length()-1;
        while(i<j){
            if(news[i] != news[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};*/


class Solution{
public:
    bool isPalindrome(string s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j){

            while(i<j && !isalnum(s[i]))i++;
            while(i<j && !isalnum(s[j]))j--;

            if(tolower(s[i]) != tolower(s[j]))return false;
            i++;
            j--;
        }
        return true;
    }
};

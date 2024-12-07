class Solution {
public:
    string reverseWords(string s) {
        string str = "", word = "";
        for (char c:s){
            if (c != ' '){
                word += c;
            }else if(!word.empty()){
                str = (word +" "+ str);
                word = "";
            }
        }
        if(!word.empty()){
            str = str = (word +" "+ str);
        }
        if(!str.empty() && str.back() == ' '){str.pop_back();}
        return str;
    }
};

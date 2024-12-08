class Solution {
public:
    string convertToTitle(int columnNumber) {
        string s = "";
        while(columnNumber > 0){
            columnNumber--;
            char current = 'A' + (columnNumber%26);
            s = current+s;
            columnNumber /= 26;
        }
        return s;
    }
};


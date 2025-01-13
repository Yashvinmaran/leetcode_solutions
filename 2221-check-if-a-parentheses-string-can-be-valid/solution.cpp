class Solution {
public:
    bool canBeValid(string s, string locked) {
        if (s.length() % 2 != 0) return false; 

        int open = 0, flexible = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked[i] == '1') {
                if (s[i] == '(') open++;
                else open--;
            } else {
                flexible++;
            }
            if (open + flexible < 0) return false;
        }

        open = 0;
        flexible = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked[i] == '1') {
                if (s[i] == ')') open++;
                else open--;
            } else {
                flexible++;
            }
            if (open + flexible < 0) return false;
        }

        return true;
    }
};


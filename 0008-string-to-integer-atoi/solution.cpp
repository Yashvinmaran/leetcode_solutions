class Solution {
public:
    int myAtoi(string s) {
        int num = 0;
        short sign = 1;
        int i = 0;
        while (i < s.length() && s[i] == ' ') i++;
        if (i < s.length() && (s[i] == '+' || s[i] == '-')) {
            sign = (s[i] == '-') ? -1 : 1;
            i++;
        }
        while (i < s.length() && isdigit(s[i])) {
            if (num > (INT_MAX - (s[i] - '0')) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            num = num * 10 + (s[i] - '0');
            i++;
        }
        return num * sign;
    }
};


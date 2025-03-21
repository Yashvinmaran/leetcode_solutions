class Solution {
public:
    string reverseStr(string s, int k) {
        for (int i = 0; i < s.length(); i += 2 * k) {
            int st = i;
            int e = min((int)s.length() - 1, i + k - 1);

            while (st < e) {
                swap(s[st], s[e]);
                st++;
                e--;
            }
        }
        return s;
    }
};


class Solution {
public:
    string longestPalindrome(string s) {
        vector<string> v;
        int l, r;
        string str = "";
        
        for (int i = 0; i < s.length(); i++) {
            l = r = i;
            str = "";
            while (l >= 0 && r < s.length()) {
                if (s[l] != s[r]) break;
                l--;
                r++;
            }
            for (int j = l + 1; j < r; j++) {
                str += s[j];
            }
            v.push_back(str);

            l = i;
            r = i + 1;
            str = "";
            while (l >= 0 && r < s.length()) {
                if (s[l] != s[r]) break;
                l--;
                r++;
            }
            for (int j = l + 1; j < r; j++) {
                str += s[j];
            }
            v.push_back(str);
        }

        string longest = "";
        for (const string &pal : v) {
            if (pal.length() > longest.length()) {
                longest = pal;
            }
        }

        return longest;
    }
};


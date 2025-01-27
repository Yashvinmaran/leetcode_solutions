class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char, int> mp;
        int maxLength = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s[i];
            if (mp.find(current) != mp.end() && mp[current] >= start) {
                start = mp[current] + 1;
            }
            mp[current] = i;
            maxLength = max(maxLength, i - start + 1);
        }

        return maxLength;
    }
};


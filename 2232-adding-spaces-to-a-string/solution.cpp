class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        vector<char> newString;
        deque<int> dq(spaces.begin(), spaces.end());
        
        for (int i = 0; i < s.length(); i++) {
            if (!dq.empty() && dq.front() == i) {
                newString.push_back(' ');
                dq.pop_front();
            }
            newString.push_back(s[i]);
        }
        
        string str(newString.begin(), newString.end());
        return str;
    }
};


class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if (s1.length() != s2.length())return false;
        int counter = 0;
        char valid[256] = {0};
        for (int i = 0; i<s1.length(); i++){
            valid[s1[i]]++;
            valid[s2[i]]--;
        }
        for (auto c : valid){
            if(c != 0) return false;
        }
        for (int i = 0; i<s1.length(); i++){
            if (s1[i] != s2[i]){
                counter ++;
            }
        }
        if (counter > 2)return false;
        return true;
    }
};

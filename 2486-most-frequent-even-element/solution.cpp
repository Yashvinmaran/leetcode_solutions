class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        map<int,int>mp;
        int flag = true;
        for (auto el: nums) {
            if (el % 2 == 0) {
                mp[el]++;
                flag = false;
            }
        }
        int fre = 0, result = -1;
        for (auto p: mp) {
            if (p.second > fre || (p.second == fre && p.first < result)) {
                fre = p.second;
                result = p.first;
            }
        }
        if (!flag) { return result; }
        return -1;
    }
};


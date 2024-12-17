class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> twoSum; 
        map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            int n = nums[i];
            int k = target - n;
            if (mp.find(k) != mp.end()) {
                twoSum.push_back(mp[k]); 
                twoSum.push_back(i);     
                return twoSum;
            }
            mp[n] = i;
        }
        return twoSum;
    }
};


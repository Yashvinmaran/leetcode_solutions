class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        long long totalPairs = (nums.size()*(nums.size()-1)/2);
        unordered_map<long long, long long>freq;
        long long goodPairs = 0;

        for (long long  i = 0; i<nums.size(); i++){
            long long diff = nums[i] - i;
            goodPairs += freq[diff];
            freq[diff]++;
        }
        return totalPairs - goodPairs;
    }
};











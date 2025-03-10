class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> answer(n);
        
        for (int i = 0, prefix = 1; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = n - 1, suffix = 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }
};


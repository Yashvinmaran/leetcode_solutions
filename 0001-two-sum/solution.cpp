class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> twoSum(2);
        for (int i = 0; i<nums.size(); i++){
            for (int j = 0; j<nums.size(); j++){
                if (i != j){
                    int add = nums[i]+nums[j];
                    if(add == target){
                        twoSum[0] = i;
                        twoSum[1] = j;
                        return twoSum;
                    }
                }
            }
        }
        return {};
    }
};

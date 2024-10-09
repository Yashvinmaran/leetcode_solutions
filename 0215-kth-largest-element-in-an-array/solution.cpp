class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int length;
        sort(nums.begin(),nums.end());
        length = nums.size();
        return nums[length-k];
    }
};

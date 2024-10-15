class Solution{
public:
    vector<vector<int>> threeSum(vector<int>& nums){
        vector<vector<int>> result;  // To store the result
    int n = nums.size();

    // Sort the array
    sort(nums.begin(), nums.end());

    for (int i = 0; i < n - 2; ++i) {
        // To avoid duplicates for the first element
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        int left = i + 1;
        int right = n - 1;
        int target = -nums[i];
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                // Found a triplet
                result.push_back({nums[i], nums[left], nums[right]});

                // Move the left pointer to avoid duplicates
                while (left < right && nums[left] == nums[left + 1]) ++left;
                // Move the right pointer to avoid duplicates
                while (left < right && nums[right] == nums[right - 1]) --right;

                // Move both pointers
                ++left;
                --right;
            } else if (sum < target) {
                ++left;  // Need a larger sum
            } else {
                --right; // Need a smaller sum
            }
        }
    }

    return result;
    }
};

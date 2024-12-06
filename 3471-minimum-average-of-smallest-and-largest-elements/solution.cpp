class Solution {
public:
    double minimumAverage(vector<int>& nums) {
        vector<double>arr;
        sort(nums.begin(),nums.end());
        deque<int>dq(nums.begin(),nums.end());

        while(!dq.empty()){
            double input = (static_cast<double>(dq.front()) + dq.back()) / 2.0;
            arr.push_back(input);
            dq.pop_front();
            dq.pop_back();
        }
        sort(arr.begin(),arr.end());
        return arr[0];
    }
};

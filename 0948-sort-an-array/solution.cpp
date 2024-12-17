class Solution {
public:
    void merge(vector<int>& v, int low, int mid, int high) {
        vector<int> newVector;
        int i = low; 
        int j = mid + 1; 

        while (i <= mid && j <= high) {
            if (v[i] <= v[j]) {
                newVector.push_back(v[i++]);
            } else {
                newVector.push_back(v[j++]);
            }
        }

        while (i <= mid) {
            newVector.push_back(v[i++]);
        }

        while (j <= high) {
            newVector.push_back(v[j++]);
        }

        for (int k = low; k <= high; k++) {
            v[k] = newVector[k - low];
        }
    }

    void divide(vector<int>& v, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            divide(v, low, mid);
            divide(v, mid + 1, high);

            merge(v, low, mid, high);
        }
    }

    vector<int> sortArray(vector<int>& nums) {
        divide(nums, 0, nums.size() - 1);
        return nums;
    }
};


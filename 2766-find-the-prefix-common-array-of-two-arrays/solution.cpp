class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
    int n = A.size();
    unordered_set<int> set1, set2;
    vector<int> vec;

    for (int i = 0; i < n; ++i) {
        set1.insert(A[i]);
        set2.insert(B[i]);

        int commonCount = 0;
        for (int num : set1) {
            if (set2.count(num)) {
                ++commonCount;
            }
        }
        vec.push_back(commonCount);
    }
    return vec;
    }
};

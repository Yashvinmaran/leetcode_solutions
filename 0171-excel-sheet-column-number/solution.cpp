class Solution {
public:
    int titleToNumber(string columnTitle) {
        long long sum = 0;
        for (int i = 0; i < columnTitle.length(); i++){
            sum = sum * 26 + (columnTitle[i]  - 64);
        }
        return sum;
    }
};

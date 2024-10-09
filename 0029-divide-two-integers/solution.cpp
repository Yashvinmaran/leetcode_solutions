class Solution {
public:
    int divide(int dividend, int divisor) {
        int long long output;
        if(dividend == INT_MIN && divisor == -1){
            return INT_MAX;
        }else{
        output = dividend/divisor;
        return output; 
        }
    }
};

class Solution {
public:
    bool isPowerOfTwo(int n) {
        bool check = false;
        int i = 0;
        unsigned long long digit = 1;
        if(n == 1){
            check = true;
        }
        while (i<=n/2){
            digit = digit*2;
            if(digit == n){
                check = true;
                break;
            }
            i++;
        }
        return check;
    }
};

class Solution {
public:
    int mySqrt(int x) {
        int result;
        if (x == 0 || x == 1){
            result = x;
        }
        else{
        for (long long i = 1; i<=x/2; i++){
            if ((i*i == x)){
                result = i;
                break;
            }else if ((i*i) > x ){
                result = (i-1);
                break;
            }
        }
        }
        return result; 
    }
};

class Solution {
public:
    bool isBalanced(string num) {
        int OddSum = 0;
        int EvenSum = 0;

        for (int i = 0; i<num.length(); i++){
            if(isdigit(num[i])){
            if(i%2 == 0){
                OddSum += (num[i] - '0');
            }else{
                EvenSum += (num[i] - '0');
            }
        }
    }
        return (OddSum == EvenSum);
    }
};

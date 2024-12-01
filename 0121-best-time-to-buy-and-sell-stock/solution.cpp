class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minprice = INT_MAX;
        int maxprice = 0;
     for (int p:prices){
        minprice = min(minprice,p);
        maxprice = max(maxprice,p-minprice);
     }   
     return maxprice;
    }
};

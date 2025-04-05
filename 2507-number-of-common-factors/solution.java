class Solution {
    public int commonFactors(int a, int b) {
        int commonFact = 0;
        int n = (b<a?b:a);
        for (int i = 1; i <= n;i++){
            if(a % i == 0 && b % i == 0)commonFact++;
        }
        return commonFact;
    }
}

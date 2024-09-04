class Solution {
public:
    int countPrimes(int n) {
        
        if(n<3)
        {
            return 0;
        }
        
        bool prime[n];
        int res=n/2;
        memset(prime,true,sizeof(prime));
        for(int i=3;i*i<n;i+=2)
        {
            if(prime[i]==true)
            {
                int k=i*2;
                for(int j=i*i;j<n;j+=k)
                {
                    if(prime[j]){
                    prime[j]=false;
                    res--;
                    }
                }
            }
        }
        
        return res;
    }
};

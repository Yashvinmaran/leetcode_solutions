class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1 ; i < n ; i++ ){
            if(isValid(n-i) && isValid(i))return new int[]{i,n-i};
        }
        System.gc();
          return new int []{0,0};
    }
    public boolean isValid(int n ){
        while(n != 0 ){
            if(n%10== 0)return false;
            n/=10;
        }
        return true;
    }
}

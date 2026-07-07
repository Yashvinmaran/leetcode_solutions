class Solution {
    public long sumAndMultiply(int n) {
        int rev = 0;
        int cont = 0;
        long sum = 0;

        while(n != 0){
            if(n%10 != 0){
                rev *= 10;
                rev += n%10;
            }
            n /= 10;
        }

        while(rev != 0){
            cont *= 10;
            cont += rev%10;
            sum += rev%10;
            rev /= 10;
        }

        return (cont * sum);
    }
}

class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10)return false;

        int remove = 10;
        boolean flag = false;
        while(n >= remove){
            n -= remove--;
            if(!flag) flag = true;
            else flag = false;
        }

        return flag;
    }
}

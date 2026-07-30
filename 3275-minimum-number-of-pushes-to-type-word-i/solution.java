class Solution {
    public int minimumPushes(String word) {

        int cnt = 0;
        for (int i = 0; i < word.length(); i++){
            if(i < 8)cnt++;
            else if(i >= 8 && i < 16)cnt += 2;
            else if(i >= 16 && i < 24)cnt += 3;
            else cnt += 4;
        }

        return cnt;
    }
}

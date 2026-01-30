class Solution {
    private static boolean isPrimeBitSet(String s){
        int cnt = 0;
        for (char c : s.toCharArray()){
            cnt += (c - '0');
        }
        
        if (cnt <= 1)return false;
        for (int i = 2; i < cnt; i++){
            if(cnt % i == 0)return false;
        }

        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        String[] binaries = new String[right - left + 1];

        for (int i = 0; left <= right; i++, left++){
            binaries[i] = Integer.toBinaryString(left);
        }

        int cnt = 0;
        for (int i = 0; i < binaries.length; i++){
            if(isPrimeBitSet(binaries[i]))cnt++;
        }
        return cnt;
    }
}

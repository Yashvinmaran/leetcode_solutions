class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;
        int[] result = new int[n+1];
        int i = 0;
        for (char c : s.toCharArray()){
            if(c == 'I')result[i++] = low++;
            else result[i++] = high--;
        }
        result[n] = low;
        return result;
    }
}

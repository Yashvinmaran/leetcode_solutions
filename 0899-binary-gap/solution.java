class Solution {
    public int binaryGap(int n) {
        char[] arr = Integer.toBinaryString(n).toCharArray();
        int left = -1;
        int right = -1;
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == '1'){
                if(left == -1)left = i;
                else if(right <= left){
                    right = i;
                    max = Math.max(max, (right - left));
                    left = right;
                }
            }
        }
        return max;
    }
}

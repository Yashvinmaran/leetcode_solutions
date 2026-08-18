class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];

        for (int i = 0; i <= n - k ; i++){
            for(int j = i; j < i + k; j++){
                freq[nums[j]]++;
            }
        }
        
        if(n == k){
            for (int i = 50; i >= 0; i--){
                if(freq[i] != 0)return i;
            }
        }
        
        for (int i = 50; i >= 0; i--){
            if(freq[i] == 1)return i;
        }

        

        return -1;
    }
}

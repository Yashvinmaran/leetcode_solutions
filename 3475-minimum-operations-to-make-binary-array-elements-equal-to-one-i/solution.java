class Solution {
    public int minOperations(int[] nums) {
        int c = 0;
        int i=2;
        int n = nums.length;
        while(i<n){
            if(nums[i-2]==0){
                nums[i-2]=nums[i-2]^1;
                nums[i-1]=nums[i-1]^1;
                nums[i]=nums[i]^1;
            c++;
            }
            i++;
        }
        i =n-1;
        while(i>n-3){
           if(nums[i]==0){
            return -1;
           }
           i--;
        }

        return c;
    }
}

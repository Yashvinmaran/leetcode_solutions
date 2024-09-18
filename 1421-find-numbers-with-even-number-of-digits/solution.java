class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        int count2 = 0;
        for (int i=0; i < nums.length ; i++){
            count = 0;
            while(nums[i]>0){
                count++;
                nums[i]/=10;
            }if(count%2 == 0){
                count2++;
            }
        }
        return count2;
    }
}

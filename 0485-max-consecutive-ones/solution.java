class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter1 = 0;
        int counter2 = 0;
        for (int i=0; i < nums.length ; i++){
            if(nums[i] == 1){
                counter1++;
                counter2 = Math.max(counter1,counter2);
            }else{
                counter1=0;
            }
        }
        return counter2;
    }
}

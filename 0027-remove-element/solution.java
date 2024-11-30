class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int p:nums){
            if (p != val){
                nums[k++] = p;
            }
        }
        return k;
    }
}

class Solution {
    public int seti(int i, int[] arr){
        for (int j = i; j<arr.length; j++){
            if(arr[j] == 0)return j;
        }
        return arr.length;
    }
    public int setj(int i, int[] arr){
        boolean flag = false;
        for (int j = i; j<arr.length; j++){
            if(arr[j] == 0 && !flag)flag = true;;
            if(arr[j] != 0 && flag)return j;
        }
        return arr.length;
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = seti(0, nums);
        int j = setj(0, nums);
        while(i<n && j<n){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i = seti(i, nums); 
            j = setj(j, nums);
        }
        for (int a : nums){
            System.out.print(a + " ");
        }
    }
}

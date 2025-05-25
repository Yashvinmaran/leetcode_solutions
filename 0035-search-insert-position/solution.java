class Solution {
    public int searchInsert(int[] arr, int num) {
         int l = 0;
        int r = arr.length - 1;
        while (l <= r){
           int mid = l + (r-l)/2;
            if(num < arr[mid]){
                r = mid -1;
            } else if (num > arr[mid]) {
                l = mid + 1;
            }else {
                return mid;
            }
        }  
        return l;
    }   
}

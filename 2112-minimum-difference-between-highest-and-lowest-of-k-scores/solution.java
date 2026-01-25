class Solution {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left; 
        int j = mid + 1;  
        int k = 0;        

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }


    public int minimumDifference(int[] nums, int k) {
        mergeSort(nums);
        int len = nums.length;
        if (k == 1 || len == 1) {
            return 0;
        } 
        int left = 0;
        int best = Integer.MAX_VALUE;
        for (int right = 0; right + k - 1 < len; right++) {
            best = Math.min(nums[right + k - 1] - nums[right], best);
        }
        return best;
    }
}

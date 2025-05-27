class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        sort(nums);
        int i = lowerBound(nums, n, k);
        return i;
    }

    private void sort(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    private void merge(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            merge(arr, l, mid);
            merge(arr, mid + 1, r);
            mergesort(arr, l, mid, r);
        }
    }

    private void mergesort(int[] arr, int l, int mid, int r) {
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];

        for (int i = 0; i < left.length; i++) left[i] = arr[l + i];
        for (int i = 0; i < right.length; i++) right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    private int lowerBound(int[] arr, int n, int target) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}


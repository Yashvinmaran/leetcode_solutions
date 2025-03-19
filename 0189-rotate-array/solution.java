class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        k = k % n;
        int d = 0;

        for (int i = n - k; i < n; i++) {
            arr[d++] = nums[i];
        }
        for (int i = 0; i < n - k; i++) {
            arr[d++] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }
}

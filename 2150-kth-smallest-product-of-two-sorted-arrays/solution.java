class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = (long) -1e10, right = (long) 1e10;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countSmallerOrEqual(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private long countSmallerOrEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int num1 : nums1) {
            if (num1 >= 0) {
                int left = 0, right = nums2.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if ((long) num1 * nums2[mid] <= target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += left;
            } else {
                int left = 0, right = nums2.length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if ((long) num1 * nums2[mid] <= target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                count += nums2.length - left;
            }
        }
        return count;
    }
}

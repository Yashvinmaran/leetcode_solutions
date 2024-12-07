class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int size = size1 + size2;
        int[] newarr = new int[size];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < size1 && j < size2) {
            if (nums1[i] < nums2[j]) {
                newarr[k++] = nums1[i++];
            } else {
                newarr[k++] = nums2[j++];
            }
        }
        while (i < size1) {
            newarr[k++] = nums1[i++];
        }
        while (j < size2) {
            newarr[k++] = nums2[j++];
        }

        if (size % 2 == 0) {
            return (newarr[size / 2 - 1] + newarr[size / 2]) / 2.0;
        }
        return newarr[size / 2];
    }
}


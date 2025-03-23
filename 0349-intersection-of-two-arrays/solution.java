class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            if (isContains(nums1[i], nums2)) {
                st.add(nums1[i]);
            }
        }

        int[] arr = new int[st.size()];
        int idx = 0;
        for (int num : st) {
            arr[idx++] = num;
        }

        return arr;
    }

    private boolean isContains(int a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (a == b[i]) return true;
        }
        return false;
    }
}


class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();

        int[] counts = new int[101];

        for (int n : nums1) {
            counts[n] |= 1; 
        }


        for (int n : nums2) {
            counts[n] |= 2; 
        }


        for (int n : nums3) {
            counts[n] |= 4; 
        }


        for (int i = 1; i <= 100; i++) {
            int mask = counts[i];
  
            if (mask == 3 || mask == 5 || mask == 6 || mask == 7) {
                ans.add(i);
            }
        }

        return ans;
    }
}


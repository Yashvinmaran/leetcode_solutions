class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++){
            int pos = map.get(nums1[i]);
            while(pos < nums2.length){
                if(nums1[i] < nums2[pos]){
                    ans[i] = nums2[pos];
                    break;
                }
                pos++;
            }
        }

        return ans;
    }
}

class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] freq = new boolean[101];

        for (int num : nums){
            freq[num] = true;
        }

        for (int i = k; i < 201; i = i + k){
            if(i > 100)return i;
            if(!freq[i])return i;
        }

        return 0;
    }
}

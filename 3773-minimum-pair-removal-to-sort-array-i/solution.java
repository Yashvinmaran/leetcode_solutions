class Solution {
    public boolean isUnsorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i))
                return true;
        }
        return false;
    }

    public int minimumPairRemoval(int[] nums) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);

        while (list.size() > 1 && isUnsorted(list)) {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 0; i < list.size() - 1; i++) {
                int currSum = list.get(i) + list.get(i + 1);
                if (currSum < minSum) {
                    minSum = currSum;
                    idx = i;
                }
            }

            list.set(idx, minSum);
            list.remove(idx + 1);
            cnt++;
        }
        return cnt;
    }

}

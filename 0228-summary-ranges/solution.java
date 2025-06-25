class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;

        String a = Integer.toString(nums[0]);
        String b = a;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                b = Integer.toString(nums[i + 1]);
            } else {
                if (!a.equals(b)) list.add(a + "->" + b);
                else list.add(a);

                a = Integer.toString(nums[i + 1]);
                b = a;
            }
        }
        if (!a.equals(b)) list.add(a + "->" + b);
        else list.add(a);

        return list;
    }
}


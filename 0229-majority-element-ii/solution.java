class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length / 3;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        for (int key : mpp.keySet()) {
            if (mpp.get(key) > n) {
                list.add(key);
            }
        }

        return list;
    }
}


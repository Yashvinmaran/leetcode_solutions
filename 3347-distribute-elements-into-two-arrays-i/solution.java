class Solution {
    public int[] resultArray(int[] nums) {
        
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if(i == 0)list1.add(nums[i]);
            else if(i == 1)list2.add(nums[i]);
            else {
                if(list1.get(list1.size() - 1) > list2.get(list2.size() - 1)){
                    list1.add(nums[i]);
                }else list2.add(nums[i]);
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++){
            if(i < list1.size())result[i] = list1.get(i);
            else result[i] = list2.get(i - list1.size());
        }

        return result;
    }
}

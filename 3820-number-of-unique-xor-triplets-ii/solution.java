class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                list.add((nums[i] ^ nums[j]));
            }
        }

       for (var l : list){
        for (int i = 0; i < nums.length; i++){
            set.add((l ^ nums[i]));
        }
       }

        return set.size();
    }
}

class Solution {

    public int totalNumbers(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                for(int k = 0; k < nums.length; k++){
                    if(i != j && i != k && j != k){
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        int cnt = 0;

        for (var s : set){
            if((s.get(s.size() - 1) % 2) == 0 && (s.get(0) != 0))cnt++;
        }
        return cnt;
    }
}

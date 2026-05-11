class Solution {

    private void add(List<Integer> list, int n){
        while(n != 0){
            list.add(n%10);
            n/=10;
        }
    }

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--){
            add(list, nums[i]);
        }

        int n = list.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++){
            ans[i] = list.get(n - i - 1);
        }
        return ans;
    }
}

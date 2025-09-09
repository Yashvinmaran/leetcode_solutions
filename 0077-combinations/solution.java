class Solution {

   private void helper(int[] arr, int k, List<List<Integer>> ans, List<Integer> set,int i){
    if(i == arr.length && set.size() == k ){
        ans.add(new ArrayList<>(set));
        return;
    }
    if(i == arr.length && set.size() != k)return;

    set.add(arr[i]);
    helper(arr, k, ans, set, i + 1);
    set.remove(set.size() - 1);
    helper(arr, k, ans, set, i + 1);
   }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++)arr[i] = (i + 1);
        helper(arr, k, ans, set, 0);
        return ans;
    }
}

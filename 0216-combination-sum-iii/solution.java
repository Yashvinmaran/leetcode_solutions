class Solution {
    public void backtracking(int k, int index, int sum, int target, List<Integer> list, List<List<Integer>> result){
        if(k==0){
            if(sum==target){
                result.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        for (int i=index;i<10;i++){
            if(sum>=target && k>=0) break;
            list.add(i);
            backtracking(k-1,i+1,sum+i,target,list,result);
            list.remove(list.size()-1);
        }
        return;
    }

    public List<List<Integer>> combinationSum3(int n, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, 1, 0, target, list, result);
        return result;
    }
}

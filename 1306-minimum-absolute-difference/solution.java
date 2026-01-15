class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int min_diff = (arr[1] - arr[0]);
        
        for (int i = 2; i < arr.length; i++){
            min_diff = Math.min((arr[i] - arr[i - 1]), min_diff);
        }

        for (int i = 1; i < arr.length; i++){
            ArrayList<Integer> pair = new ArrayList<>();
            if((arr[i] - arr[i - 1]) == min_diff){
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }
}

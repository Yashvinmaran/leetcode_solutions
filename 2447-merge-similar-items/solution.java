class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] weights = new int[1001];
        for (int[] item : items1) {
            weights[item[0]] = item[1];
        }
        for (int[] item : items2) {
            weights[item[0]] += item[1];
        }

        List<List<Integer>> mergeSimilarItem = new ArrayList<>();
        for (int val = 0; val < 1001; val++) {
            if (weights[val] != 0) {
                mergeSimilarItem.add(Arrays.asList(val, weights[val]));
            }
        }
        return mergeSimilarItem;
    }
}

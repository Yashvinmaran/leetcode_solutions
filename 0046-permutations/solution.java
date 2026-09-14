class Solution {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void findPermute(int[] arr, int idx, int n, List<List<Integer>> result) {
        if (idx == n) {
            List<Integer> currentList = new ArrayList<>();
            for (int num : arr) {
                currentList.add(num);
            }
            result.add(currentList);
            return;

        }

        for (int i = idx; i <= n; i++) {
            swap(arr, i, idx);
            findPermute(arr, idx + 1, n, result);
            swap(arr, i, idx);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        findPermute(nums, 0, nums.length - 1, result);

        return result;
    }
}

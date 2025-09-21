class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int n = s.length();
        int start = 0;

        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (i - start + 1 >= 3) {
                    list.add(Arrays.asList(start, i));
                }
                start = i + 1;
            }
        }
        return list;
    }
}


class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int a : arr1) {
            while (a > 0) {
                set.add(a);
                a /= 10;
            }
        }

        int max_len = 0;
        for (int a : arr2) {
            while (a > 0) {
                if (set.contains(a)) {
                    int curr_len = (int) Math.log10(a) + 1;
                    max_len = Math.max(curr_len, max_len);
                    
                    break; 
                }
                a /= 10;
            }
        }

        return max_len;
    }
}


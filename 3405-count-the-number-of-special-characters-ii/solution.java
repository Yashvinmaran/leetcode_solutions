class Solution {
    public int numberOfSpecialChars(String word) {
        int i = 0, len = word.length();
        char[] arr = word.toCharArray();
        int[] indexes = new int[256];
        Arrays.fill(indexes, -1);
        int count = 0;
        for (;i < len;++i) {
            if (arr[i] >= 97) indexes[arr[i]] = i;
            else if (indexes[arr[i]] == -1) indexes[arr[i]] = i;
        }

        for (i=65; i <=90; ++i) {
            if (indexes[i+32] != -1 && indexes[i+32] < indexes[i]) {
                ++count;}
        }
        return count;
    }
}

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[queries.length];

        int[] prefix = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            prefix[i + 1] = prefix[i] + (isVowels(words[i]) ? 1 : 0);
        }

        for (int i = 0; i < queries.length; i++) {
            int p = queries[i][0];
            int q = queries[i][1];
            arr[i] = prefix[q + 1] - prefix[p];
        }

        return arr;
    }

    private boolean isVowels(String s) {
        char start = s.charAt(0);
        char end = s.charAt(s.length() - 1);
        return isVowel(start) && isVowel(end);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}


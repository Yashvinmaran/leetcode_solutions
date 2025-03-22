class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        int count = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            int index = ch - 'a';
            if (!seen[index]) {
                seen[index] = true;
                count++;
                if (count == 26) return true;
            }
        }

        return false;
    }
}


class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        int length = 0;
        boolean usedCenter = false;

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (String word : count.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (!word.equals(rev)) {
                if (count.containsKey(rev)) {
                    int pairCount = Math.min(count.get(word), count.get(rev));
                    length += pairCount * 4;
                    count.put(word, count.get(word) - pairCount);
                    count.put(rev, count.get(rev) - pairCount);
                }
            } else {
                int pairCount = count.get(word) / 2;
                length += pairCount * 4;
                count.put(word, count.get(word) - pairCount * 2);

                if (count.get(word) > 0 && !usedCenter) {
                    length += 2;
                    usedCenter = true;
                }
            }
        }

        return length;
    }
}

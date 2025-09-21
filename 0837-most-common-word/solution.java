class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[^A-z]+");
        
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }

        Map<String, Integer> freq = new HashMap<>();
        String ans = "";
        int max = 0;

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) continue;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
            if (freq.get(word) > max) {
                max = freq.get(word);
                ans = word;
            }
        }

        return ans;
    }
}


class Solution {

    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        int shift = s.charAt(0) - 'a';

        for (char c : s.toCharArray()) {
            char normalized = (char)((c - 'a' - shift + 26) % 26 + 'a');
            sb.append(normalized);
        }
        return sb.toString();
    }

    public long countPairs(String[] words) {
        Map<String, Long> map = new HashMap<>();

        for (String word : words) {
            String key = normalize(word);
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        long ans = 0;
        for (long count : map.values()) {
            ans += count * (count - 1) / 2;
        }
        return ans;
    }
}


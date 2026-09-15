class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int required = map.size();
        int left = 0;

        List<Integer> ans = new ArrayList<>();

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
            if (map.get(s.charAt(right)) == 0) {
                required--;
            }
            while (required == 0 && left <= right) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
                if (map.get(s.charAt(left)) > 0) {
                    required++;
                }
                if (right - left + 1 == p.length()) {
                    ans.add(left);
                }
                left++;
            }
        }

        return ans;
    }
}

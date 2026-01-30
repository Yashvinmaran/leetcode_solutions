class Solution {
    private static boolean isValid(char[] arr, Map<Character, Integer> originalMap) {
        Map<Character, Integer> map = new HashMap<>(originalMap); 

        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        for (var key : map.keySet()) {
            if (map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : licensePlate.toLowerCase().replaceAll("[\\s\\d]", "").toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String shortestWord = null;

        for (String word : words) {
            if (isValid(word.toCharArray(), map)) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }
        }
        return shortestWord;
    }
}


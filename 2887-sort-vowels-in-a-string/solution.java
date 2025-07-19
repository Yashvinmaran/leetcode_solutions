class Solution {
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public String sortVowels(String s) {
        int n = s.length();
        List<Character> vowels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                sb.append(vowels.get(j++));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}


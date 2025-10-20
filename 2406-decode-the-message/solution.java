class Solution {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26]; 
        Arrays.fill(map, '&');
        char ch = 'a';
        
        for (char c : key.toCharArray()) {
            if (c != ' ' && map[c - 'a'] == '&') {
                map[c - 'a'] = ch++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append(c == ' ' ? ' ' : map[c - 'a']);
        }

        return sb.toString();
    }
}


class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                char prev = sb.charAt(sb.length() - 1);
                char shifted = (char) ((prev - 'a' + (c - '0')) % 26 + 'a');
                sb.append(shifted);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}


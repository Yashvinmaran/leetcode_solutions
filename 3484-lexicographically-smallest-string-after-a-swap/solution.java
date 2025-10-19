class Solution {

    public String getSmallestString(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            if (ch1 > ch2 && ch1 % 2 == ch2 % 2) {
                sb.setCharAt(i, ch2);
                sb.setCharAt(i + 1, ch1);
                break;
            }
        }

        return sb.toString();
    }
}

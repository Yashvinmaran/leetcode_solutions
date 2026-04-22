class Solution {
    public String reformatNumber(String number) {

        int len = number.length();
        char[] chars = new char[len + len / 3];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            char ch = number.charAt(i);

            if (ch >= '0' && ch <= '9') {
                chars[idx++] = ch;

                if (idx % 4 == 3) {
                    chars[idx++] = '-';
                }
            }
        }

        if (idx % 4 == 0) {
            idx--;
        }

        if (chars[idx - 2] == '-') {
            chars[idx - 2] = chars[idx - 3];
            chars[idx - 3] = '-';
        }

        return new String(chars, 0, idx);
    }
}

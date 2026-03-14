class Solution {
    private int cnt = 0;
    private String result = "";

    public String getHappyString(int n, int k) {
        if (k > 3 * (1 << (n - 1))) {
            return "";
        }
        helper(n, new StringBuilder(), '#', k);
        return result;
    }

    private void helper(int n, StringBuilder sb, char lastChar, int k) {
        if (result.length() > 0) {
            return;
        }

        if (sb.length() == n) {
            cnt++;
            if (cnt == k) {
                result = sb.toString();
            }
            return;
        }

        for (char c : new char[]{'a', 'b', 'c'}) {
            if (c != lastChar) {
                sb.append(c);
                helper(n, sb, c, k);
                if (result.length() > 0) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1); 
            }
        }
    }
}


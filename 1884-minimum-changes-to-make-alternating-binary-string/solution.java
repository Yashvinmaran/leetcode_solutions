public class Solution {
    public int minOperations(String s) {
        int cnt_0 = 0;
        int cnt_1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    cnt_1++;
                } else {
                    cnt_0++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    cnt_1++;
                } else {
                    cnt_0++;
                }
            }
        }

        return Math.min(cnt_0, cnt_1);
    }
}

class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String intermediate = s;
        int interInt = 0;
        while (intermediate.length() > k) {
            for (int i = 0; i < intermediate.length(); i += k) {
                for (int j = i; j < i + k && j < intermediate.length(); j++) {
                    interInt += intermediate.charAt(j) - '0';
                }
                sb.append(interInt);
                interInt = 0;
            }
            intermediate = sb.toString();
            sb.setLength(0);
        }
        return intermediate;
    }
}

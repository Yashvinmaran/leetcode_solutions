public class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removeGain(s, 'a', 'b', x, y);
        } else {
            return removeGain(s, 'b', 'a', y, x);
        }
    }
    private int removeGain(String s, char first, char second, int firstVal, int secondVal) {
        int total = 0;
        StringBuilder firstPass = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = firstPass.length();
            if (len > 0 && firstPass.charAt(len - 1) == first && c == second) {
                firstPass.deleteCharAt(len - 1);
                total += firstVal;
            } else {
                firstPass.append(c);
            }
        }
        StringBuilder secondPass = new StringBuilder();
        for (char c : firstPass.toString().toCharArray()) {
            int len = secondPass.length();
            if (len > 0 && secondPass.charAt(len - 1) == second && c == first) {
                secondPass.deleteCharAt(len - 1);
                total += secondVal;
            } else {
                secondPass.append(c);
            }
        }
        return total;
    }
}


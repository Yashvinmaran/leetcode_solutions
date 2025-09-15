class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char replaceMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                replaceMax = c;
                break;
            }
        }
        String maxStr = replaceMax == ' ' ? s : s.replace(replaceMax, '9');
        char replaceMin = s.charAt(0);
        String minStr = s.replace(replaceMin, '0');

        int maxNum = Integer.parseInt(maxStr);
        int minNum = Integer.parseInt(minStr);

        return maxNum - minNum;
    }
}


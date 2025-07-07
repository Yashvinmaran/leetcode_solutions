class Solution {
    public String removeDigit(String number, char digit) {
        int lastIndex = -1;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                if (i + 1 < number.length() && number.charAt(i + 1) > digit) {
                    return number.substring(0, i) + number.substring(i + 1);
                }
                lastIndex = i; // keep updating to track the last occurrence
            }
        }

        // if no better option found, remove the last occurrence
        return number.substring(0, lastIndex) + number.substring(lastIndex + 1);
    }
}


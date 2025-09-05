class Solution {
    public String addStrings(String nums1, String nums2) {
        int i = nums1.length() - 1;
        int j = nums2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += nums1.charAt(i--) - '0';
            if (j >= 0) sum += nums2.charAt(j--) - '0';
            sb.append((char) ('0' + sum % 10));
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}


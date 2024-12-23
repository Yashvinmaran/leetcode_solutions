class Solution {
    string addBinaryStrings(string a, string b) {
        string result = "";
        int carry = 0;

        while (a.length() < b.length()) a = '0' + a;
        while (b.length() < a.length()) b = '0' + b;

        for (int i = a.length() - 1; i >= 0; i--) {
            int bitA = a[i] - '0';
            int bitB = b[i] - '0';
            int sum = bitA + bitB + carry;

            result = char((sum % 2) + '0') + result;
            carry = sum / 2;
        }
        if (carry) result = '1' + result;

        return result;
    }

public:
    string addBinary(string a, string b) {
        return addBinaryStrings(a, b);
    }
};


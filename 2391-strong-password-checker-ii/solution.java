class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        byte lowercase = 0, uppercase = 0, digit = 0, specialCharacter = 0; 

        for (int i = 0; i < n; i++) {
            char ch = password.charAt(i);
            if (i < n - 1) {
                if (ch == password.charAt(i + 1)) {
                    return false;
                }
            }

            if (ch >= 'a' && ch <= 'z') {
                lowercase++;
            }else if (ch >= 'A' && ch <= 'Z') {
                uppercase++;
            } else if (ch >= '0' && ch <= '9') {
                digit++;
            }else {
                specialCharacter++;
            }
        }

        return lowercase > 0 && uppercase > 0 && digit > 0 && specialCharacter > 0 ? true : false;
    }
}

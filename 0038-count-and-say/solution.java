public class Solution{
    public static String countAndSay(int n) {
        if (n <= 0) return "";

        String result = "1"; 

        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prevChar = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char currChar = result.charAt(j);
                if (currChar == prevChar) {
                    count++;
                } else {
                    current.append(count).append(prevChar);
                    count = 1;
                    prevChar = currChar;
                }
            }

            current.append(count).append(prevChar);
            result = current.toString();
        }

        return result;
    }
}

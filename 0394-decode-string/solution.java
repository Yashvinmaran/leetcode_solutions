class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); 
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr.toString());
                num = 0;
                currStr.setLength(0);
            } else if (c == ']') {
                int repeatCount = numStack.pop();
                String temp = currStr.toString();
                currStr = new StringBuilder(strStack.pop());
                while (repeatCount-- > 0) {
                    currStr.append(temp);
                }
            } else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}

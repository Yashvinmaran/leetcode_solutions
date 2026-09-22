class Solution {
    public String decodeString(String s) {
       
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> resultStack = new ArrayDeque<>();
        
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(k);
                resultStack.push(currentString);
                
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder decodedString = resultStack.pop();
                int currentK = counts.pop();
                
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}


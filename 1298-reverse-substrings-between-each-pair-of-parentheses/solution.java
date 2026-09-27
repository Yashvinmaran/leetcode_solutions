class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder curr = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '(') {
                    curr.append(st.pop());
                }
                
                if (!st.isEmpty()) {
                    st.pop(); // Remove the matching '('
                }
                
                for (int i = 0; i < curr.length(); i++) {
                    st.push(curr.charAt(i));
                }
            } else {
                st.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        
        return result.reverse().toString();
    }
}


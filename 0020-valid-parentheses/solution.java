class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char p : s.toCharArray()) {
            if (p == '(' || p == '[' || p == '{') {
                stack.push(p);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((p == ')' && top != '(') || 
                    (p == ']' && top != '[') || 
                    (p == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

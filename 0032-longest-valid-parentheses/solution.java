class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}

// Less optimise code :-
/*class Solution {
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public int longestValidParentheses(String s) {
        int n = s.length();
        int m = 0;
        for (int len = 2; len <= n; len++) { 
            for (int i = 0; i <= n - len; i++) {
                String sub = s.substring(i, i+ len); 
                if(check(sub)){
                    m = Math.max(m, sub.length());
                }
            }
        }
        return m;
    }
}*/

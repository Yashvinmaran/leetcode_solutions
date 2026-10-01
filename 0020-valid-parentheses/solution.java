class Solution {
    public boolean isValid(String s) {

        int n = s.length();
        if(n % 2 == 1)return false;

        char[] st = new char[n];
        int top = -1;

        for (char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                st[++top] = c;
            }else {
                if(top == -1)return false;
                if(c == ')' && st[top] != '(')return false;
                if(c == '}' && st[top] != '{')return false;
                if(c == ']' && st[top] != '[')return false;
                top--;
               }
        }

        return top == -1;
    }
}

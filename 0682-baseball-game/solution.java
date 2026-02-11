import java.util.Stack;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
        for (String op : ops) {
            switch (op) {
                case "C":
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                    break;
                case "D":
                    if (!st.isEmpty()) {
                        st.push(st.peek() * 2);
                    }
                    break;
                case "+":
                    if (st.size() >= 2) {
                        int last = st.pop();
                        int newTop = last + st.peek();
                        st.push(last);
                        st.push(newTop);
                    }
                    break;
                default:
                    st.push(Integer.parseInt(op));
                    break;
            }
        }
        
        int sum = 0;
        for (int score : st) {
            sum += score;
        }
        return sum;
    }
}


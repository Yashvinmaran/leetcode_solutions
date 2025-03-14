import java.util.*;

class MyStack {
    private Queue<Integer> arr;

    public MyStack() {
        arr = new LinkedList<>();
    }

    public void push(int x) {
        arr.offer(x);
        int size = arr.size();
        while (size-- > 1) {
            arr.offer(arr.poll());
        }
    }

    public int pop() {
        return arr.poll();
    }

    public int top() {
        return arr.peek();
    }

    public boolean empty() {
        return arr.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


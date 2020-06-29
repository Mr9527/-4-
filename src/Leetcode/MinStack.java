package Leetcode;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min_stack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.size() <= 0) {
            min_stack.push(x);
            return;
        }
        min_stack.push(Math.min(min_stack.peek(), x));
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

}

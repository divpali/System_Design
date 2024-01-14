import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */

public class Design_MinStack {

    Stack<Integer> stack;
    int min;

    Design_MinStack() {
        stack = new Stack<>();
        min = 0;
    }

    public void push(int data) {
        if(stack.isEmpty()) {
            min = data;
            stack.push(data);
            return;
        }

        if (min > data) {
            stack.push(2 * data - min);
            min = data;
        } else {
            stack.push(data);
        }
    }

    public void pop() {

        if (stack.isEmpty()) {
            System.out.println("Stack underflow");
        }

        int top = stack.peek();

        if (top < min) {
            //min wil change if the current min is removed
            min = 2*min - top;
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Design_MinStack d = new Design_MinStack();
        d.push(10);
        d.push(13);
        d.push(3);
        System.out.println(d.getMin());
        d.pop();
        d.push(2);
        System.out.println(d.top());
    }
}

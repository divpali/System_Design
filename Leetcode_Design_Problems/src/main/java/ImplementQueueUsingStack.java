import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enQueue(int x) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }

    public int deQueue() {
        if (s1.isEmpty()) {
            System.out.println("stack is empty");
        }
        return s1.pop();
    }

    public static void main(String[] args) {

        ImplementQueueUsingStack i = new ImplementQueueUsingStack();
        i.enQueue(8);
        i.enQueue(9);
        i.enQueue(13);
        System.out.println(i.deQueue());
    }
}

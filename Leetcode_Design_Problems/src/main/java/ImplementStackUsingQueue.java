import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;

    }

    public int pop() {
        return q2.poll();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueue i = new ImplementStackUsingQueue();
        i.push(8);
        i.push(9);
        i.push(13);
    }

}

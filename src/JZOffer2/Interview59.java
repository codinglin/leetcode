package JZOffer2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Interview59 {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public Interview59() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if(deque.isEmpty()) {
            return -1;
        }else {
            return deque.peekFirst();
        }
    }

    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.add(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        } else {
            int pop = queue.poll();
            if(deque.peekFirst() == pop) {
                deque.pollFirst();
            }
            return pop;
        }
    }
}

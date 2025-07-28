package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * keep a queue of fixed size
 * like a sliding window, removing out of bound element when size exceeds
 */
public class L346_MovingAverageFromDataStream {
    Queue<Integer> queue;
    double sum;
    int size;

    public L346_MovingAverageFromDataStream(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        return sum / queue.size();
    }
}

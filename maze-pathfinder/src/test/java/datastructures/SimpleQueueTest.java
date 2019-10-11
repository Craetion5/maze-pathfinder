package datastructures;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jethulk
 */
public class SimpleQueueTest {

    public SimpleQueueTest() {
    }

    /**
     * Queue stores are returns values correctly.
     */
    @Test
    public void testUseCases() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.enqueue(5);
        queue.enqueue(6);
        Assert.assertTrue(queue.dequeue() == 5);
        queue.enqueue(8);
        Assert.assertTrue(queue.dequeue() == 6);
        Assert.assertTrue(queue.dequeue() == 8);
    }
}

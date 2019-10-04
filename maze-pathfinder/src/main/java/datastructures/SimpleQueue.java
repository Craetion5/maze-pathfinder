package datastructures;

/**
 *
 * @author jethulk
 */
public class SimpleQueue<E extends Object> {

    private E[] array;
    private int firstIndex;
    private int lastIndex;

    /**
     * A simple queue implementation.
     */
    public SimpleQueue() {
        firstIndex = 0;
        lastIndex = 0;
        array = (E[]) new Object[150];
    }

    public void enqueue(E e) {
        array[lastIndex] = e;
        lastIndex++;
    }

    public E dequeue() {
        E e = array[firstIndex];
        firstIndex++;
        return e;
    }

    public boolean isEmpty() {
        return array[firstIndex] == null;
    }
}

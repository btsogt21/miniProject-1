import java.util.NoSuchElementException;
/** A Queue interface for FIFO-ordered queues.*/
public interface Queue <E> {
    /**Add an element to tail-end of the queue. IllegalStateException if the queue cannot be expanded. */
    public void add (E element) throws IllegalStateException;

    /** Remove and return element from the head of the queue.NoSuchElementException if the queue is empty.*/
    public E remove () throws NoSuchElementException;

    /**Return the element at the head of the queue without removal. NoSuchElementException if the queue is empty.*/
    public E peek () throws NoSuchElementException;

    /**Return queue length*/
    public int size ();
}

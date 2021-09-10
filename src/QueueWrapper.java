import java.util.LinkedList;
import java.util.NoSuchElementException;

/** Implement a queue using the Queue methods of a LinkedList.*/
public class QueueWrapper <E> implements Queue <E> {
    /** Linked list to store queue elements in */
    private LinkedList<E> _storage;

    /** Constructor that creates empty queue. */
    public QueueWrapper () {
        _storage = new LinkedList<E>();
    }
    /** Add element to queue tail. Throws IllegalStateException if the queue cannot be expanded.*/
    public void add (E element) throws IllegalStateException {
        _storage.add(element);
    }
    /** Remove element from queue head and return said element. Throws NoSuchElementException if queue is empty.*/
    public E remove () throws NoSuchElementException {
        return _storage.remove();
    }
    /** Return head of queue without removing. Throws NoSuchElementException if the queue is empty.*/
    public E peek () throws NoSuchElementException {
        return _storage.element();
    }
    /** Return length of queue. */
    public int size () {
        return _storage.size();
    }
}


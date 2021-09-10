import java.util.LinkedList;
import java.util.NoSuchElementException;

/** Implementation of a stack using stack methods of a LinkedList.*/
public class StackWrapper <E> implements Stack <E> {

    /** Linked list to store stack elements in */
    private LinkedList<E> _storage;

    /** Constructor to create an empty stack */
    public StackWrapper () {
        _storage = new LinkedList<E>();
    }

    /** Adds element to top of stack. Throws IllegalStateException if stack cannot be expanded to allow for addition */
    public void push (E element) throws IllegalStateException {
        _storage.push(element);
    }

    /** Remove topmost stack item, return it. Throws NoSuchElementException error if there is nothing to remove*/
    public E pop () throws NoSuchElementException {
        return _storage.pop();
    }

    /** Return top element of stack*/
    public E top () throws NoSuchElementException {
        return _storage.getFirst();
    }

    /** Returns length of stack*/
    public int size () {
        return _storage.size();
    }
}
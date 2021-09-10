import java.util.NoSuchElementException;
/**Stack interface for LIFO-ordered stacks.*/
public interface Stack <E> {
    /**Add an element to the top of stack. IllegalStateException if the stack cannot be expanded.*/
    public void push (E element) throws IllegalStateException;

    /**Remove and return element from the top of the stack. NoSuchElementException if the stack is empty.*/
    public E pop () throws NoSuchElementException;

    /** Return top element on the stack without removing it. NoSuchElementException if the stack is empty.*/
    public E top () throws NoSuchElementException;

    /**Return height of the stack.*/
    public int size ();

}
import java.util.NoSuchElementException;
/** A stack implemented using queues.*/
public class StackofQueues <E> implements Stack <E> {
    /** The queue in which the stack's elements will be stored. */
    private Queue<E> _queue1;
    private Queue<E> _queue2;
    /** Constructor.  Creates empty stacks using WrapperQueue.*/
    public StackofQueues () {
        _queue1 = new QueueWrapper<E>();
        _queue2 = new QueueWrapper<E>();
    }
    /** Add an element to the top of the stack. IllegalStateException if the stack cannot be expanded.
     */
    public void push (E element) throws IllegalStateException {
        _queue2.add(element);
        while(_queue1.size()!=0){
            _queue2.add(_queue1.remove());
        }
        Queue<E> queue_holder = _queue1;
        _queue1 = _queue2;
        _queue2 = queue_holder;
    }
    /**Remove and return element from the top of the stack.NoSuchElementException if the stack is empty.*/
    public E pop () throws NoSuchElementException {
        return _queue1.remove();
    }

    /**Return top element of stack without removal.NoSuchElementException if the stack is empty.*/
    public E top () throws NoSuchElementException {
        return _queue1.peek();
    }

    /** Return the number of elements on the stack. */
    public int size () {
        return _queue1.size();
    }
}

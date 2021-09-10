import java.util.NoSuchElementException;

/** Queue implemented using stacks.*/
public class QueueofStacks <E> implements Queue <E> {
    /** The stack in which the queue's elements will be stored. */
    private Stack<E> _stack1;
    private Stack<E> _stack2;

    /** Constructor creating empty queues using WrapperStack.*/
    public QueueofStacks () {
        _stack1 = new StackWrapper<E>();
        _stack2 = new StackWrapper<E>();
    }

    /**
     * Add an element to end of queue. IllegalStateException if the queue cannot be expanded.*/
    public void add (E element) throws IllegalStateException {
        _stack1.push(element);
    }
    /**Remove and return element from the head of the queue. NoSuchElementException if the queue is empty.*/
    public E remove () throws NoSuchElementException {
        if(_stack2.size()==0){
            while(_stack1.size()!=0){
                _stack2.push(_stack1.pop());
            }
        }
        return _stack2.pop();
    }
    /**Return element from the head of the queue. NoSuchElementException if the queue is empty.*/
    public E peek () throws NoSuchElementException {
        if(_stack2.size()==0){
            while(_stack1.size()!=0){
                _stack2.push(_stack1.pop());
            }
        }
        return _stack2.top();
    }
    /** Return length of queue */
    public int size () {
        return _stack1.size() + _stack2.size();
    }
}

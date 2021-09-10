import java.util.NoSuchElementException;
/**Test implementation of AmhQueue(Interface) against an implementation we know to be correct and working.*/
public class TestQueue {
    public static void main (String[] args) {

        // Creating Queue of Stacks and WrapperQueue
        Queue<Integer> testQueue      = new QueueofStacks<Integer>();
        Queue<Integer> referenceQueue = new QueueWrapper<Integer>();

        // Enqueuing
        enqueue(testQueue, referenceQueue, 1);
        enqueue(testQueue, referenceQueue, 2);
        enqueue(testQueue, referenceQueue, 3);

        // Dequeuing
        dequeue(testQueue, referenceQueue);
        dequeue(testQueue, referenceQueue);
        dequeue(testQueue, referenceQueue);

        // Dequeue too many
        dequeue(testQueue, referenceQueue);

        // Testing peek and size methods
        enqueue(testQueue, referenceQueue, 10);
        enqueue(testQueue, referenceQueue, 20);
        enqueue(testQueue, referenceQueue, 30);
        dequeue(testQueue, referenceQueue);
        peek(testQueue, referenceQueue);
        size(testQueue, referenceQueue);

    }

    private static void enqueue (Queue<Integer> testQueue, Queue<Integer> referenceQueue, Integer value) {
        // Insert value into working queue.
        boolean referenceSuccess;
        try {
            referenceQueue.add(value);
            referenceSuccess = true;
        } catch (IllegalStateException e) {
            referenceSuccess = false;
        }

        // Insert value into test queue.
        boolean testSuccess;
        try {
            testQueue.add(value);
            testSuccess = true;
        } catch (IllegalStateException e) {
            testSuccess = false;
        }

        // Did both succeed/fail in the same way?
        if (referenceSuccess != testSuccess) {
            System.err.printf("enqueue success mismatch: adding %d, test = %b, ref = %b\n", value, testSuccess, referenceSuccess);
        }

    }

    private static void dequeue (Queue<Integer> testQueue, Queue<Integer> referenceQueue) {


        // Dequeue from reference queue.
        boolean referenceSuccess;
        int     referenceValue = 0;
        try {
            referenceValue   = referenceQueue.remove();
            referenceSuccess = true;
        } catch (NoSuchElementException e) {
            referenceSuccess = false;
        }

        // Dequeue from test queue.
        boolean testSuccess;
        int     testValue = 0;
        try {
            testValue   = testQueue.remove();
            testSuccess = true;
        } catch (NoSuchElementException e) {
            testSuccess = false;
        }

        // Did both succeed/fail the same way?
        if (referenceSuccess != testSuccess) {
            System.err.printf("dequeue success mismatch: test = %b, ref = %b\n", testSuccess, referenceSuccess);
        } else {
            // If they succeeded, did the values match?
            if (testSuccess && (testValue != referenceValue)) {
                System.err.printf("dequeue value mismatch: test = %d, ref = %b\n", testValue, referenceValue);
            }

        }
    }
    private static void peek (Queue<Integer> testQueue, Queue<Integer> referenceQueue) {
        boolean referenceSuccess;
        int referenceValue = 0;
        try {
            referenceValue = referenceQueue.peek();
            referenceSuccess = true;
        }
        catch (NoSuchElementException e){
            referenceSuccess = false;
        }
        boolean testSuccess;
        int     testValue = 0;
        try {
            testValue   = testQueue.peek();
            testSuccess = true;
        } catch (NoSuchElementException e) {
            testSuccess = false;
        }
        if (referenceSuccess != testSuccess) {
            System.err.printf("peek success mismatch: test = %b, ref = %b\n",
                    testSuccess,
                    referenceSuccess);
        } else {

            // If they succeeded, did the values match?
            if (testSuccess && (testValue != referenceValue)) {
                System.err.printf("peek value mismatch: test = %d, ref = %b\n", testValue, referenceValue);
            }
        }
    }

    private static void size (Queue<Integer> testQueue, Queue<Integer> referenceQueue) {
        boolean referenceSuccess;
        int referenceValue = 0;
        try {
            referenceValue = referenceQueue.size();
            referenceSuccess = true;
        }
        catch (NoSuchElementException e){
            referenceSuccess = false;
        }
        boolean testSuccess;
        int     testValue = 0;
        try {
            testValue   = testQueue.size();
            testSuccess = true;
        } catch (NoSuchElementException e) {
            testSuccess = false;
        }
        if (referenceSuccess != testSuccess) {
            System.err.printf("size success mismatch: test = %b, ref = %b\n", testSuccess, referenceSuccess);
        } else {

            // If they succeeded, did the values match?
            if (testSuccess && (testValue != referenceValue)) {
                System.err.printf("size value mismatch: test = %d, ref = %b\n", testValue, referenceValue);
            }
        }
    }
}

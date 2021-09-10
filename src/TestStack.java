import java.util.NoSuchElementException;
/**Test implementation of Stack(Interface) against an implementation known to be working.*/
public class TestStack {
    public static void main (String[] args) {
        // Make one StackofQueues to test, and one WrapperStack to test it against.
        Stack<Integer> testStack      = new StackofQueues<Integer>();
        Stack<Integer> referenceStack = new StackWrapper<Integer>();

        // Stacking
        push(testStack, referenceStack, 1);
        push(testStack, referenceStack, 2);
        push(testStack, referenceStack, 3);

        // Destacking.
        pop(testStack, referenceStack);
        pop(testStack, referenceStack);
        pop(testStack, referenceStack);

        // Pop too many.
        pop(testStack, referenceStack);

        // test top and size functionality
        push(testStack, referenceStack, 1);
        push(testStack, referenceStack, 5);
        push(testStack, referenceStack, 2353);
        pop(testStack, referenceStack);
        top(testStack, referenceStack);
        size(testStack, referenceStack);
    }

    private static void push (Stack<Integer> testStack, Stack<Integer> referenceStack, Integer value) {

        // Insert value into working stack.
        boolean referenceSuccess;
        try {
            referenceStack.push(value);
            referenceSuccess = true;
        } catch (IllegalStateException e) {
            referenceSuccess = false;
        }

        // Insert value into test stack.
        boolean testSuccess;
        try {
            testStack.push(value);
            testSuccess = true;
        } catch (IllegalStateException e) {
            testSuccess = false;
        }

        // Did both succeed/fail in the same way?
        if (referenceSuccess != testSuccess) {
            System.err.printf("push success mismatch: adding %d, test = %b, ref = %b\n", value, testSuccess, referenceSuccess);
        }
    }

    private static void pop (Stack<Integer> testStack, Stack<Integer> referenceStack) {

        // Pop from the reference stack.
        boolean referenceSuccess;
        int     referenceValue = 0;
        try {
            referenceValue   = referenceStack.pop();
            referenceSuccess = true;
        } catch (NoSuchElementException e) {
            referenceSuccess = false;
        }

        // Pop from the test stack.
        boolean testSuccess;
        int     testValue = 0;
        try {
            testValue   = testStack.pop();
            testSuccess = true;
        } catch (NoSuchElementException e) {
            testSuccess = false;
        }

        // Did both succeed/fail the same way?
        if (referenceSuccess != testSuccess) {
            System.err.printf("pop success mismatch: test = %b, ref = %b\n", testSuccess, referenceSuccess);
        } else {
            // If they succeeded, did the values match?
            if (testSuccess && (testValue != referenceValue)) {
                System.err.printf("pop value mismatch: test = %d, ref = %b\n", testValue, referenceValue);
            }
        }
    }

    private static void top (Stack<Integer> testStack, Stack<Integer> referenceStack) {
        boolean referenceSuccess;
        int     referenceValue = 0;
        try {
            referenceValue   = referenceStack.top();
            referenceSuccess = true;
        } catch (NoSuchElementException e) {
            referenceSuccess = false;
        }

        boolean testSuccess;
        int     testValue = 0;
        try {
            testValue   = testStack.top();
            testSuccess = true;
        } catch (NoSuchElementException e) {
            testSuccess = false;
        }

        if (referenceSuccess != testSuccess) {
            System.err.printf("top success mismatch: test = %b, ref = %b\n",
                    testSuccess,
                    referenceSuccess);
        } else {

            if (testSuccess && (testValue != referenceValue)) {
                System.err.printf("top value mismatch: test = %d, ref = %b\n",
                        testValue,
                        referenceValue);
            }
        }
    }
    private static void size (Stack<Integer> testStack, Stack<Integer> referenceStack) {
        boolean referenceSuccess;
        int     referenceValue = 0;
        try {
            referenceValue   = referenceStack.size();
            referenceSuccess = true;
        } catch (NoSuchElementException e) {
            referenceSuccess = false;
        }

        boolean testSuccess;
        int     testValue = 0;
        try {
            testValue   = testStack.size();
            testSuccess = true;
        } catch (NoSuchElementException e) {
            testSuccess = false;
        }

        if (referenceSuccess != testSuccess) {
            System.err.printf("size success mismatch: test = %b, ref = %b\n", testSuccess, referenceSuccess);
        } else {

            if (testSuccess && (testValue != referenceValue)) {
                System.err.printf("size value mismatch: test = %d, ref = %b\n", testValue, referenceValue);
            }
        }
    }
}

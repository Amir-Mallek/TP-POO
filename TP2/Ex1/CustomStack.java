public class CustomStack {
    private final int capacity;
    private int size;
    private final int[] theStack;

    public CustomStack(int capacity) {
        theStack = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void addElement(int element) throws StackOverflowException {
        if (size == capacity) throw new StackOverflowException();
        theStack[size] = element;
        size++;
    }

    public void removeElement() throws StackEmptyException {
        if (size == 0) throw new StackEmptyException();
        size--;
    }

    public int lastInStack() throws StackEmptyException {
        if (size == 0) throw new StackEmptyException();
        return theStack[size-1];
    }

    public boolean stackIsEmpty() { return size == 0; }

    public boolean stackIsFull() { return size == capacity; }
}

public class CustomStack {
    private int capacity;
    private int size;
    private int[] theStack;

    public CustomStack(int capacity) {
        this.theStack = new int[capacity];
        this.capacity = capacity;
    }

    public void addElement(int element) {
        if (size == capacity) return;
        theStack[size] = element;
        size++;
    }

    public void removeElement() {
        if (size == 0) return;
        size--;
    }

    public int lastInStack() {
        if (size == 0) return 0;
        return theStack[size-1];
    }

    public boolean stackIsEmpty() { return size == 0; }

    public boolean stackIsFull() { return size == capacity; }

}

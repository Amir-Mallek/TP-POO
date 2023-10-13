public class CustomArrayList {
    private int capacity;
    private int size;
    private int[] customList;

    public CustomArrayList() {
        customList = new int[10];
        capacity = 10;
        size = 0;
    }

    public CustomArrayList(int initialSize) {
        customList = new int[initialSize];
        capacity = initialSize;
        size = 0;
    }

    private void formatList() {    // double the size of the array if it is full
        if (size == capacity) {    // and recopy the existing elements in the new and bigger array
            int[] newList = new int[2*capacity];
            System.arraycopy(customList, 0, newList, 0, size);
            customList = newList;
            capacity *= 2;
        }
    }

    public void add(int number) {
        formatList();
        customList[size] = number;
        size++;
    }

    public void add(int index, int number) {
        formatList();
        for (int i = size; i > index; i--) {   //
            customList[i] = customList[i-1];   // shifting elements after "index" one step to the right
        }                                      //
        customList[index] = number;
        size++;
    }

    public int get(int index) {
        return customList[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isIn(int number) {
        for (int i = 0; i < size; i++) {
            if (number == customList[i]) return true;
        }
        return false;
    }

    public int find(int number) {
        for (int i = 0; i < size; i++) {
            if (number == customList[i]) return i;
        }
        return -1;
    }

    public void remove(int number) {
        int index = find(number);
        for (int i = index; i < size-1; i++) { //
            customList[i] = customList[i+1];   // shifting elements after "index" one step to the left
        }                                      //
        size--;
    }
}

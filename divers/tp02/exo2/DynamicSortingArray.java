package tp02.exo2;

import java.util.Arrays;

public class DynamicSortingArray {
    private int capacity;
    private int increment;
    private int[] data;

    public DynamicSortingArray(int capacity, int increment) {
        this.capacity = capacity;
        this.increment = increment;
        data = new int[this.capacity];
        initialize();
    }

    public void insert(int value) {
        int nbElements = elements();
        if (nbElements == capacity) {
            growSize();
        }
        data[nbElements] = value;
        Arrays.sort(data);
    }

    public void remove(int value) {
        int nbElements = elements();
        if (nbElements > 0) {
            for (int i = 0; i < nbElements; i++) {
                if (data[i] == value) {
                    data[i] = Integer.MAX_VALUE;
                    break;
                }
            }
            shrinkSize();
            capacity -= 1;
        }
    }

    public int elements() {
        int count = 0;

        while (count < capacity) {
            if (data[count] == Integer.MAX_VALUE) {
                break;
            }
            count++;
        }
        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements(); i++) {
            sb.append(data[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    private void initialize() {
        for (int i = 0; i < capacity; i++) {
            data[i] = Integer.MAX_VALUE;
        }
    }

    private void growSize() {
        int[] newData = null;
        int nbElements = elements();

        if (nbElements == capacity) {
            newData = new int[capacity + increment];
            if (capacity >= 0) System.arraycopy(data, 0, newData, 0, capacity);
        }
        capacity = capacity + increment;
        data = newData;
    }

    private void shrinkSize() {
        int[] newData;
        int count = elements();

        if (count > 0) {
            newData = new int[count];

            System.arraycopy(data, 0, newData, 0, count);
            capacity = count;
            data = newData;
        }
    }

}

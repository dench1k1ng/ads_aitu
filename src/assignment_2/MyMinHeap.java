package assignment_2;

@SuppressWarnings("unchecked")
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.aadd(item);
        siftUp(heap.size() - 1);
    }

    public T extractMin() {
        if (heap.size() == 0) return null;
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);
        siftDown(0);
        return min;
    }

    public T peekMin() {
        if (heap.size() == 0) return null;
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void siftDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}

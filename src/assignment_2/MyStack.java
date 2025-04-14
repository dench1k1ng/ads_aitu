package assignment_2;

public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        T last = list.getLast();
        list.removeLast();
        return last;
    }

    public T peek() {
        return list.getLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}

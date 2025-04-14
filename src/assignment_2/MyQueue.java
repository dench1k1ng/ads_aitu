package assignment_2;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item); // Вставка в конец
    }

    public T dequeue() {
        T front = list.getFirst(); // Первый элемент
        list.removeFirst();        // Удалить из начала
        return front;
    }

    public T peek() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}

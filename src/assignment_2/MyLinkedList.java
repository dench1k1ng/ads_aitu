package assignment_2;

@SuppressWarnings("unchecked")
public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T data;
        MyNode next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void aadd(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkBounds(index);
        getNode(index).data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode next = getNode(index);
            MyNode prev = next.prev;
            MyNode newNode = new MyNode(item);
            newNode.prev = prev;
            newNode.next = next;
            prev.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return getNode(index).data;
    }

    private MyNode getNode(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        MyNode target = getNode(index);
        MyNode prev = target.prev;
        MyNode next = target.next;

        if (prev != null) prev.next = next;
        else head = next;

        if (next != null) next.prev = prev;
        else tail = prev;

        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sort not implemented");
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (T item : this) {
            if (item.equals(object)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        MyNode current = tail;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            MyNode current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}

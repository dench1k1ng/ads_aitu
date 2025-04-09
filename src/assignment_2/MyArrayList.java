package assignment_2;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i]; //upcasting
        }
        elements = newElements;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index]; //downcasting
    }

    @Override
    public T getFirst() {
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        return (T) elements[elements.length - 1];
    }

    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[length - 1] = null; // удаляем дубликат последнего
        length--;
    }

    @Override
    public void removeFirst() {
        elements = Arrays.copyOfRange(elements, 1,length - 1);
    }

    @Override
    public void removeLast() {
        elements = Arrays.copyOfRange(elements, 0,length - 2);
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                T a = (T) elements[j];
                T b = (T) elements[j + 1];
                if (a != null && b != null && a.compareTo(b) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    private void checkIndex(int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    public int size() {
        return length;
    }

    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null; // удаляем ссылки на все элементы
        }
        length = 0; // обнуляем количество элементов
    }

    @Override
    public void aadd(T item) {

    }

    public void set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
package assignment_2;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    private MyNode<T> node;
    private int length;
    public MyLinkedList(){
        node = null;
        length = 0;
    }

    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if(node==null){
            node = newNode;
        }
        else{
            MyNode<T> current = node;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;

        }
        length++;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

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

    @Override
    public void clear() {

    }

    @Override
    public void aadd(T item) {
        
    }

    @Override
    public void set(int index, T item) {

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
    public T get(int index) {
        if(index<0 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
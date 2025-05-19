package assignment_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MyArrayList ===");
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.addShort(5);
        arrayList.addShort(3);
        arrayList.addShort(8);
        arrayList.addShort(1);
        print(arrayList);
        arrayList.sort();
        System.out.println("Sorted:");
        print(arrayList);

        System.out.println("\n=== MyLinkedList ===");
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.addFirst("C");
        linkedList.addLast("A");
        linkedList.add(1, "B");
        print(linkedList);
        linkedList.remove(1);
        System.out.println("After remove index 1:");
        print(linkedList);

        System.out.println("\n=== MyStack ===");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());

        System.out.println("\n=== MyQueue ===");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Size: " + queue.size());

        System.out.println("\n=== MyMinHeap ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(50);
        heap.insert(20);
        heap.insert(30);
        heap.insert(10);
        heap.insert(40);

        System.out.println("ExtractMin: " + heap.extractMin());
        System.out.println("PeekMin: " + heap.peekMin());
        System.out.println("Size: " + heap.size());
    }

    public static <T> void print(MyList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

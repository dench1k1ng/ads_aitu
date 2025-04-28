package assignment_3.BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(7, "seven");

        System.out.println(bst.get(3));
        System.out.println(bst.get(7));

        // Итерация по дереву
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }
    }
}

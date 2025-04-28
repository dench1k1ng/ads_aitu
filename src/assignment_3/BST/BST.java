package assignment_3.BST;


import java.util.Stack;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V value) {
        root = put(root, key, value);
    }
    private Node put(Node node, K key, V value) {
        if (node == null) return new Node(key, value, null, null);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;
        return node;
    }
    public V get(K key) {
        return get(key);
    }
    private V get(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.value;
    }
    public void delete(K key) {
        delete(root, key);
    }
    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) delete(node.left, key);
        else if (cmp > 0) delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return node;
    }
    public Iterable<K> iterator() {
        Stack<K> keys = new Stack<>();
        Stack<Node> stack = new Stack<>();
        pushLeft(root, stack);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            keys.push(node.key);
            pushLeft(node.left, stack);
        }
        return keys;
    }

    private void pushLeft(Node node, Stack<Node> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

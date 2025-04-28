package assignment_3.MyHashTable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>(7);

        hashTable.put("apple", 10);
        hashTable.put("banana", 20);
        hashTable.put("cherry", 30);
        hashTable.put("date", 40);

        System.out.println("Добавили");
        System.out.println(hashTable);

        System.out.println("\nБерем 'banana': " + hashTable.get("banana")); // 20

        System.out.println("Есть 30: " + hashTable.contains(30)); // true
        System.out.println("Есть 50: " + hashTable.contains(50)); // false

        System.out.println("Ключ для 40: " + hashTable.getKey(40)); // date
        System.out.println("Клюя для 50: " + hashTable.getKey(50)); // null

        System.out.println("\nУбираем 'banana'...");
        Integer removedValue = hashTable.remove("banana");
        if (removedValue != null) {
            System.out.println("Удалленое: " + removedValue); // 20
        } else {
            System.out.println("Key 'banana' not found.");
        }

        System.out.println("\nПосле удаления 'banana':");
        System.out.println(hashTable);

        System.out.println("\nБерем 'banana': " + hashTable.get("banana"));

        System.out.println("\nРазмеры: " + hashTable.size());
        System.out.println("Пустая? " + hashTable.isEmpty());

        hashTable.remove("apple");
        hashTable.remove("cherry");
        hashTable.remove("date");

        System.out.println("\nЩа как выглядет:");
        System.out.println(hashTable);
        System.out.println("Размеры таблицы: " + hashTable.size());
        System.out.println("Пустая? " + hashTable.isEmpty());
    }
}
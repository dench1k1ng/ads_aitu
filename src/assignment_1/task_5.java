package assignment_1;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
        sc.close();
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

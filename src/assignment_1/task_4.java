package assignment_1;

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fact = factorial(n);
        System.out.println(fact);
        sc.close();
    }

    public static int factorial(int n) {
        if (n <= 0) return 1;
        return n * factorial(n - 1);
    }
}

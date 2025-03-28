package assignment_1;

import java.util.Scanner;

public class task_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverse(n));
        sc.close();
    }

    public static String reverse(int n) {
        if (n <= 0) return "";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return reverse(n - 1) + s + " ";
    }
}

package assignment_1;

import java.util.Scanner;

public class task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(power(a,b));
        sc.close();
    }
    public static int power(int n, int p) {
        if (p == 0) return 1;
        return n * power(n, p - 1);
    }

}

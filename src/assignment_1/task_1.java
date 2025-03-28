package assignment_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int minimum = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        sc.close();
        System.out.println(minimum);
    }
}

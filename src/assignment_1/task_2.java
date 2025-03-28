package assignment_1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int n1 = sc1.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc1.nextInt();}

        double avg = 0;
        for (int i = 0; i < n1; i++) {
            avg += arr1[i];
        }
        sc1.close();
        System.out.println(avg / n1);
    }
}

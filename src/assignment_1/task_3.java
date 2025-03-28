package assignment_1;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner sc2 = new Scanner(System.in);
        int n2 = sc2.nextInt();
        boolean flag = true;
        for (int i = 2; i < n2 / 2; i++) {
            if (n2 % i == 0) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
        sc2.close();
    }
}

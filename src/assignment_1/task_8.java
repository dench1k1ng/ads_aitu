package assignment_1;

import java.util.Scanner;

public class task_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isInt(s));
        sc.close();
    }
    public static boolean isInt(String s) {
        if (s.isEmpty()) return true;
        int ch = s.charAt(s.length() - 1);
        boolean isInt2 = ch >= '0' && ch <= '9';
        if ((ch == 45 || ch == 43) && s.length() == 1) return true;
        return isInt2 && isInt(s.substring(0, s.length() - 1));
    }
}

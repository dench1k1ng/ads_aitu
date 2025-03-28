import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //4


        //5
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(fibonacci(n));
//        sc.close();


        //6
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(power(a,b));
//        sc.close();

        //7
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(reverse(n));
//        sc.close();

        //8
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(isInt(s));
//        sc.close();

        //9


    }



    public static int power(int n, int p) {
        if (p == 0) return 1;
        return n * power(n, p - 1);
    }

    public static String reverse(int n) {
        if (n <= 0) return "";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return reverse(n - 1) + s + " ";
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean isInt(String s) {
        if (s.isEmpty()) return true;
        int ch = s.charAt(s.length() - 1);
        boolean isInt2 = ch >= '0' && ch <= '9';
        if ((ch == 45 || ch == 43) && s.length() == 1) return true;
        return isInt2 && isInt(s.substring(0, s.length() - 1));
    }
}
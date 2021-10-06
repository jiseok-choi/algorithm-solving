package programmers.level1;

import java.util.Scanner;

public class 직사각형_별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // System.out.println(a + b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append("*");
        }
        for (int i = 0; i < b; i++) {
            System.out.println(sb);
        }
    }
}

package cheatSteet;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // sc 예시
        sc.next();
        sc.nextInt();
        sc.nextLine();
        // sb 예시
        sb.append(1).append("ab");
        sb.toString();
        System.out.println(sb);
    }
}

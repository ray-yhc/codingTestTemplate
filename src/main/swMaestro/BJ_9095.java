package swMaestro;

import java.util.Scanner;

public class BJ_9095 {
    public static int[][] dp = new int[301][2];

    public static int solution(int N) {
        return 0;
    }

    public static void main(String[] args) throws Exception {

        int N, T;
        //System.setIn(new java.io.FileInputStream("src/main/testTxt/test_no12.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            System.out.println(solution(N));
        }
    }
}

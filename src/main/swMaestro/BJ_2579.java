package swMaestro;

import java.util.Scanner;

public class BJ_2579 {
    public static int[][] dp = new int[301][2];

    public static int solution(int N, int[] score) {
        dp[0][0] = score[0];
        dp[0][1] = 0;

        if (N>1) {
            dp[1][0] = dp[0][0] + score[1];
            dp[1][1] = score[1];
        }

        for (int i = 2; i < N; i++) {
            dp[i][0] = dp[i - 1][1] + score[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];
        }

        return Math.max(dp[N-1][0], dp[N-1][1]);
    }

    public static void main(String[] args) throws Exception {

        int N;
        //System.setIn(new java.io.FileInputStream("src/main/testTxt/test_no12.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] score = new int[N];

        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }
        System.out.println(solution(N, score));
    }
}

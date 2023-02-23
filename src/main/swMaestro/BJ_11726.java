package swMaestro;

import java.util.Scanner;

public class BJ_11726 {
    public static long[][] dp = new long[501][501];

    public static long solution(int N, int[][] cost) {
        dp[1][1] = cost[1][1];
        long max = dp[1][1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1)
                    dp[i][j] = dp[i - 1][j] + cost[i][j];
                else if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + cost[i][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + cost[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) throws Exception {

        int N, T;
        int[][] cost = new int[501][501];
        //System.setIn(new java.io.FileInputStream("src/main/testTxt/test_no12.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(N, cost));
    }
}

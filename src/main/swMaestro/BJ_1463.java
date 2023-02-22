package swMaestro;

import java.util.Scanner;

import java.util.*;

public class BJ_1463 {
    public static int[] dp = new int[1_000_001];
    public static int INF = 2_000_000;

    public static int solution(int N) {
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        int one, two, three;
        for (int i = 4; i <= N; i++) {
            one = dp[i - 1] + 1;
            if (i % 2 == 0)
                two = dp[i / 2] + 1;
            else two = INF;
            if (i % 3 == 0)
                three = dp[i / 3] + 1;
            else three = INF;

            dp[i] = Math.min(Math.min(one, two), three);
        }

        return dp[N];
    }

    public static void main(String[] args) throws Exception {

        int N;
        //System.setIn(new java.io.FileInputStream("src/main/testTxt/test_no12.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        System.out.println(solution(N));
    }
}

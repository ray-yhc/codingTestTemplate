package swMaestro;

import java.util.Scanner;

public class BJ_9184 {
    public static int[][][] dp = new int[21][21][21];

    public static void solution(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;

        sb.append("w(")
                .append(a).append(", ")
                .append(b).append(", ")
                .append(c).append(") = ");

        if (a<=0 || b<=0 || c<=0) {
            sb.append(1);
            System.out.println(sb);
            return;
        }
        if (a>20 || b> 20 || c>20)
            a = b = c = 20;

        if(dp[a][b][c] != 0)
            ans = dp[a][b][c];
        else{
            for(int i = 1; i<=a; i++)
                for(int j = 1; j<=b; j++)
                    for(int k = 1; k<=c; k++)
                        w(i,j,k);
            ans = dp[a][b][c];
        }

        sb.append(ans);
        System.out.println(sb);
    }

    public static void w(int a, int b, int c) {
        if(dp[a][b][c] != 0)
            return;

        if (a<b && b<c)
            dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
        else
            dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
    }

    public static void main(String[] args) throws Exception {

        int a=0,b=0,c=0;
        //System.setIn(new java.io.FileInputStream("src/main/testTxt/test_no12.txt"));
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i<= 20; i++)
            for (int j = 0; j<= 20; j++){
                dp[0][i][j] = 1;
                dp[j][0][i] = 1;
                dp[i][j][0] = 1;
            }

        while  (true){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (a == -1 && b == -1 && c == -1)
                break;
            solution(a,b,c);
        }
    }
}

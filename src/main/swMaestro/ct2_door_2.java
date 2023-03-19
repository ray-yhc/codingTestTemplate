package swMaestro;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ct2_door_2 {

    public static int[] solution(int n, int k, int[][] door) {
        int[] status = new int[door.length];
        Queue<EnterPerson> ep = new LinkedList<>();

        int remainTime = 0, prevEnteredTime = 0;

        for (int i = 0; i < door.length; i++) {
            int curEnteredTime = door[i][0];
            remainTime -= curEnteredTime - prevEnteredTime;
            if (remainTime < 0) remainTime = 0;

            if (remainTime == 0) {
                remainTime += k;
                while (!ep.isEmpty()) {
                    EnterPerson enterence = ep.poll();
                    status.
                }
            } else {
                if (remainTime < n / 2) { // 들어왔는데 못나감
                    ep.add(new EnterPerson(i, curEnteredTime, n / 2 - remainTime));
                    remainTime = 0;
                } else
                    status[i] = curEnteredTime + n / 2;
            }
            prevEnteredTime = curEnteredTime;
        }

        return status;
    }


    // 코테에서는 사용하지 않았지만, 프로그램을 실행하고 inout을 받기 위한 코드!
    public static void main(String[] args) throws Exception {
        int T, N, K, M;
        System.setIn(new java.io.FileInputStream("src/main/testTxt/door.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            N = sc.nextInt();
            K = sc.nextInt();
            M = sc.nextInt();
            int[][] door = new int[M][2];
            for (int j = 0; j < M; j++) {
                door[j][0] = sc.nextInt();
                door[j][1] = sc.nextInt();
            }

            int[] result = solution(N, K, door);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length; j++)
                sb.append(result[j]).append(" ");
            System.out.println(sb);
        }
    }
}

class EnterPerson {
    int id;
    int enteredTime;
    int remainTime;

    public EnterPerson(int id, int enteredTime, int remainTime) {
        this.id = id;
        this.enteredTime = enteredTime;
        this.remainTime = remainTime;
    }
}
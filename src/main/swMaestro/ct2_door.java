package swMaestro;

import java.util.*;

public class ct2_door {
    public static int distance;     // 입구 - 출구 거리 == n/2
    public static int currentTime;  // 현재 시간 표시
    public static boolean isMoving; // 회전문 움직이는지 여부

    public static int[] solution(int n, int k, int[][] door) {
        distance = n/2;
        isMoving = false;
        currentTime = 0;

        int[] status = new int[door.length];            // 양수 : i번째 사람의 도착시각 , 음수 : i번째 사람의 위치
        boolean[] started = new boolean[door.length];   // i번째 사람이 출발했는지 여부
        PriorityQueue<Event> pq = new PriorityQueue<>();

        for (int i = 0; i < door.length; i++)           // 각 사람의 회전문 입장시각 예약
            pq.offer(new Event(2, i, door[i][0]));

        while (!pq.isEmpty()) {
            Event event = pq.poll();
            updateStatus(status, started, event.time);

            // 1 - 회전문 종료 / 2 - 사람 입장
            if (event.type == 1)            // 회전문 종료
                isMoving = false;
            else if (isMoving)              // 회전문 움직이는 도중에 사람 들어옴
                started[event.id] = true;
            else {                          // 회전문 멈춰있는 상테에서 사람 들어옴 -> 회전문 상태 변경
                isMoving = true;
                pq.offer(new Event(1, 0,  currentTime + k)); // 회전문 종료시각 예약
                started[event.id] = true;
            }
        }

        // status가 음수인 경우 = 아직 회전문 속에 있는 경우 -> -1 로 바꿔준다.
        for (int i = 0; i < door.length; i++)
            if (status[i] < 0) status[i] = -1;
        return status;
    }

    private static void updateStatus(int[] status, boolean[] started, int until) {
        if (currentTime == until) return;

        for (int i=0; i<status.length; i++){
            // 이미 회전문을 나갔거나 || 아직 들어오지 않은 경우
            if (status[i] > 0 || !started[i]) continue;

            int pos = - status[i];

            if (distance - pos < until - currentTime)       // until 이전에 탈출 가능한경우
                status[i] = currentTime + distance - pos;   // 탈출시각 저장
            else {                                          // until 이전에 탈출 불가능한경우
                pos += until - currentTime;
                status[i] = - pos;                          // until 에서의 위치 저장
            }
        }
        currentTime = until;
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

class Event implements Comparable<Event> {
    public int type; // 1 - 회전문 종료 / 2 - 사람 입장
    public int id; // type1 : 0으로 표시 / type2 : 해당 사람의 index
    public int time;

    public Event(int type, int id, int time) {
        this.type = type;
        this.time = time;
        this.id = id;
    }

    @Override
    public int compareTo(Event o) { // (중요!) 시간순 정렬, 같은 시간일 경우 [회전문 종료]가 먼저 실행되어야 한다!!
        if (this.time == o.time) return this.type - o.type;
        return this.time - o.time;
    }
}
package swMaestro;

import java.util.Scanner;
import java.util.*;
public class BJ_2667 {
    public static boolean[][] visited = new boolean[25][25];
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};


    public static void solution(int N, int[][] map) {

        StringBuilder sb = new StringBuilder();

        List<Integer> towns = new LinkedList<Integer>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[j][i] && map[j][i] == 1) {
                    towns.add(BFS(i, j, N, map));
                }
            }
        }

        Collections.sort(towns);
        sb.append(towns.size()).append('\n');
        for(int i=0;i<towns.size();i++){
            sb.append(towns.get(i)).append('\n');
        }
        System.out.println(sb);
    }

    public static int BFS(int x, int y, int N, int[][] map){
        int count = 0;
        Queue<Node> que = new LinkedList<Node>();
        que.offer(new Node(x,y));

        while(!que.isEmpty()){
            x = que.peek().x;
            y = que.peek().y;
            que.poll();

            if (visited[y][x]) continue;
            visited[y][x] = true;
            count ++;

            for (int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || nx>=N|| ny<0||ny>=N)
                    continue;

                if(!visited[ny][nx] && map[ny][nx] == 1)
                    que.offer(new Node(nx,ny));
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {

        int N, T;
        //System.setIn(new java.io.FileInputStream("src/main/testTxt/test_no12.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] map = new int[N][N];
        String str;
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            str = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }


        solution(N, map);
    }
}

class Node{
    public int x; public int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
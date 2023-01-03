package cheatSteet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    // 출처 : https://codingnojam.tistory.com/44

    /**
     * 방문처리에 사용 할 배열선언
     */
    static boolean[] visited;

    /**
     * 그림예시 그래프의 연결상태를 2차원 배열로 표현 <br>
     * 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태<br>
     * 예) {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
     */
    static List<Integer>[] graph;



    public static void main(String[] args) {
        // 그래프 생성
        int V = 8;
        visited = new boolean[V+1];
        graph = new List[V+1];

        graph[1] = new ArrayList<>(List.of(2,3,8)); // Arrays.asList
        graph[2] = new ArrayList<>(List.of(1, 6, 8));
        graph[3] = new ArrayList<>(List.of(1, 5));
        graph[4] = new ArrayList<>(List.of(5, 7));
        graph[5] = new ArrayList<>(List.of(3, 4, 7));
        graph[6] = new ArrayList<>(List.of(2));
        graph[7] = new ArrayList<>(List.of(4,5));
        graph[8] = new ArrayList<>(List.of(1, 2));

        // dfs 실행
        dfs(1);
    }

    static void dfs(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;

        // 작업 수행
        System.out.print(nodeIndex + " -> ");

        // 방문한 노드에 인접한 노드 찾기
        for (int node : graph[nodeIndex]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if(!visited[node]) {
                dfs(node);
            }
        }
    }

}

package cheatSteet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {

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

        BFS(1, V);
    }

    /**
     * 시작 노드 nodeIndex <br>
     * BFS 탐색
     */
    static void BFS(int nodeIndex, int V) {
        // BFS 구현을 위한 큐(Queue) 생성
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // initialize : 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
        visited[nodeIndex] = true;
        queue.add(nodeIndex);

        // 큐(Queue)의 노드가 모두 사라질 때 까지 반복
        while (queue.size() != 0) {
            // 작업 수행
            // 방문한 노드를 큐에서 추출(dequeue)하고 해당 노드에 대해 작업 수행
            nodeIndex = queue.poll();
            System.out.print(nodeIndex + " -> ");

            // 방문한 노드와 인접한 모든 노드를 가져온다.
            for(int node : graph[nodeIndex]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
package cheatSteet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveXY {

    static int[][] graph;
    static int[] move_x = {1, 0, -1, 0};
    static int[] move_y = {0, -1, 0, 1};


    public static void main(String[] args) {
        graph = new int[][] {{73, 69, 70, 67, 74},
                {70, 72, 70, 75, 67},
                {70, 70, 65, 76, 70},
                {72, 70, 71, 67, 70},
                {72, 77, 67, 72, 72}};

        List<Integer> movingControl = new ArrayList<>(Arrays.asList(0,0,3,3,0,1,2));

        footPrint(0, 0, movingControl);
    }

    static void footPrint(int x, int y, List<Integer> moving) {
        System.out.print(graph[y][x] + " -> ");
        for (int m : moving) {
            int nx = x + move_x[m];
            int ny = y + move_y[m];

            if (ny < 0 || ny >= graph.length || nx < 0 || nx >= graph[0].length)
                continue;
            x = nx;
            y = ny;

            System.out.print(" -> " + graph[y][x]);
        }
    }
}

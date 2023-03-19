package swMaestro;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ct1_chopstick {

    public static int solution(int N, String[] strs) {
        StringBuilder Sticks = new StringBuilder();
        for (int i = 0; i < N; i++)
            Sticks.append(strs[i]);

        Queue<StickSet> que = new LinkedList<>();
        que.offer(new StickSet(Sticks.toString(), N, 0));

        while (!que.isEmpty()) {
            StickSet ss = que.poll();

            if (ss.isCorrect()) return ss.count;

            for (int s = 0; s + 2 < 2 * N; s++) {
                String newSs = ss.getSwapSticks(s, s + 2);
                if (newSs.equals(ss.sticks)) continue;

                que.offer(new StickSet(
                        newSs,
                        N,
                        ss.count + 1
                ));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int N, T;
        System.setIn(new java.io.FileInputStream("src/main/testTxt/chopstick_test.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            N = sc.nextInt();
            String[] strs = new String[N];
            for (int j = 0; j < N; j++) {
                strs[j] = sc.next();
            }
            System.out.println(solution(N, strs));
        }
    }
}

class StickSet {
    String sticks;
    int members;
    int count;

    StickSet(String sticks, int members, int count) {
        this.sticks = sticks;
        this.members = members;
        this.count = count;
    }

    boolean isCorrect() {
        for (int i = 0; i < sticks.length(); i += 2) {
            if (sticks.charAt(i) != sticks.charAt(i + 1)) return false;
        }
        return true;
    }

    String getSwapSticks(int ia, int ib) {
        if (ia > ib) {
            int t = ib;
            ib = ia;
            ia = t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sticks.substring(0, ia))
                .append(sticks.charAt(ib))
                .append(sticks.substring(ia + 1, ib))
                .append(sticks.charAt(ia))
                .append(sticks.substring(ib + 1));
        return sb.toString();
    }
}
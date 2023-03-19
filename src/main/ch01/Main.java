//package ch01;
//
//import cheatSteet.Timer;
//
//import java.io.InputStream;
//import java.time.Year;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        // init ////////////////////////////////////////
//        Timer timer = new Timer();
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        /////////////////////////////////////////////////
//        // code start ///////////////////////////////////
//
//        int N = sc.nextInt();
//        timer.start();
//        int M = sc.nextInt();
//        boolean[] btn = new boolean[10];
//        Arrays.fill(btn, true);
//
//        for (int i = 0; i < M; i++) {
//            btn[sc.nextInt()] = false;
//        }
//
//        int result = calResult(N, btn);
//
//        System.out.println(result);
//        // code end  ////////////////////////////////////
//        timer.end();
//        System.out.println("=========================");
////        System.out.println("function called : " + count);
//        System.out.println("elapsedTime : " + timer.getTimeAsString());
//    }
//
//
//    // M>=N
//    static int calResult(int N, boolean[] btn) {
//        final int INIT = 100;
//
//        // 근처 바로 아래/ 바로 윗 값 찾기
//        int min = -1, max = -1;
//        for (int i = 0; i < 10; i++) {
//            if (btn[i]) {
//                min = i;
//                break;
//            }
//        }
//        for (int i = 9; i >= 0; i--) {
//            if (btn[i]) {
//                max = i;
//                break;
//            }
//        }
//
//        if (min == -1 || max == -1)
//            return Math.abs(N - INIT);
//
//
//        int temp = N;
//        Stack<Integer> NList = new Stack<>();
//        while (temp > 0) {
//            NList.add(temp % 10);
//            temp /= 10;
//        }
//
//        int smlMax = 0; // N보다 작은 수 중 가장 큰 수
//        int bigMin = 0; // N보다 큰 수 중 가장 작은 수
//        for (int i = 0; i < NList.size(); i++) {
//            int n = NList.pop();
//            if (btn[n]) {
//                smlMax = smlMax * 10 + n;
//                bigMin = bigMin * 10 + n;
//            } else {
//                int sml = -1, big = -1;
//                for (int j = n; j >= min; j--) {
//                    if (btn[j]) {
//                        sml = j;
//                        break;
//                    }
//                }
//                for (int j = n; j <= max; j++) {
//                    if (btn[j]) {
//                        big = j;
//                        break;
//                    }
//                }
//                smlMax = (sml != -1)? smlMax * Math.pow(10,NList.size()+1) + ;
//                if (sml != -1) {
//                    smlMax = smlMax*10 + sml;
//                    for (int j = 0; j < NList.size(); j++) {
//                        smlMax = smlMax*10 + max;
//                    }
//                } else {
//                    getUnderOne
//
//                    for (int j = 0; j < NList.size()+1; j++) {
//                        smlMax = smlMax*10 + max;
//                    }
//                }
//
//
//                if (big != -1) {
//                    bigMin = bigMin*10 + big;
//                    for (int j = 0; j < NList.size(); j++) {
//                        bigMin = bigMin*10 + min;
//                    }
//                } else {
////                    getUpperOne
//
//                    for (int j = 0; j < NList.size()+1; j++) {
//                        bigMin = bigMin*10 + min;
//                    }
//                }
//                break;
//            }
//        }
//
//        return Math.min(Math.abs(N - INIT),
//                Math.min(btnCount + N - smlMax, btnCount + bigMin - N));
//    }
//}
package ch01;

import cheatSteet.Timer;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        // init ////////////////////////////////////////
        Timer timer = new Timer();
        timer.start();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        /////////////////////////////////////////////////
        // code start ///////////////////////////////////

        System.out.println(sayHello());

        // code end  ////////////////////////////////////
        System.out.println("elapsedTime(ns) : " + timer.end());
    }

    /**
     * cmd + shift + T : 테스트 클래스 생성
     */

    public static String sayHello(){
        return "hello";
    }
}
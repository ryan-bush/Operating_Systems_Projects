package com.ryanbush;

public class Experiment6 {
    public static void main(String args []) throws Exception {

        MyThread6.count = 0 ;

        MyThread6 thread1 = new MyThread6();
        MyThread6 thread2 = new MyThread6();

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;

        System.out.println("MyThread6.count = " + MyThread6.count) ;
    }
}

class MyThread6 extends Thread {

    static volatile int count ;

    String name ;

    public void run() {

        for(int i = 0 ; i < 100000000 ; i++) {
            increment() ;
        }
    }

    static void increment() {
        int x = count ;
        count = x + 1 ;
    }
}

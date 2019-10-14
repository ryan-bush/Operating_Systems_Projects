package com.ryanbush;

public class Experiment5 {
    public static void main(String args []) throws Exception {

        MyThread5.count = 0 ;

        MyThread5 thread1 = new MyThread5();
        MyThread5 thread2 = new MyThread5();

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;

        System.out.println("MyThread5.count = " + MyThread5.count) ;
    }
}

class MyThread5 extends Thread {

    static volatile int count ;

    String name ;

    public void run() {

        for(int i = 0 ; i < 100000000 ; i++) {
            increment() ;
        }
    }

    synchronized static void increment() {
        int x = count ;
        count = x + 1 ;
    }
}

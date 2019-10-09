package com.ryanbush;

public class Experiment3 {
    public static void main(String args []) throws Exception {

        MyThread3.count = 0 ;

        MyThread3 thread1 = new MyThread3();
        MyThread3 thread2 = new MyThread3();

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;

        System.out.println("MyThread3.count = " + MyThread3.count) ;
    }
}

class MyThread3 extends Thread {

    volatile static int count ;

    public void run() {

        for(int i = 0 ; i < 1000000000 ; i++) {
            int x = count ;
            count = x + 1 ;
        }
    }
}

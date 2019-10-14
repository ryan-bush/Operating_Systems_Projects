package com.ryanbush;

import java.util.concurrent.*;

public class Experiment4 {
    public static void main(String args []) throws Exception {

        MyThread4.count = 0 ;

        MyThread4 thread1 = new MyThread4() ;
        thread1.name = "A" ;

        MyThread4 thread2 = new MyThread4() ;
        thread2.name = "B" ;

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;

        System.out.println("MyThread4.count = " + MyThread4.count) ;
    }
}

class MyThread4 extends Thread {


    volatile static int count ;

    static Semaphore mySemaphore = new Semaphore(1);

    String name ;

    public void run() {
        try {

            for(int i = 0 ; i < 10 ; i++) {
                delay() ;

                mySemaphore.acquire() ;  // P - decrease semaphore

                int x = count ;
                System.out.println("Thread " + name + " read " + x) ;
                delay() ;
                count = x + 1 ;
                System.out.println("Thread " + name + " wrote " + (x + 1)) ;

                mySemaphore.release() ;  // V - increase semaphore
            }

        }
        catch(Exception e) {}
    }

    void delay() {

        int delay = (int) (1000 * Math.random()) ;
        try {
            Thread.sleep(delay) ;
        }
        catch(Exception e) {
        }
    }
}
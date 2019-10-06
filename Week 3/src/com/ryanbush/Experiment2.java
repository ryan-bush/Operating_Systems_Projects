package com.ryanbush;

public class Experiment2 {
    public static void main(String args []) throws Exception {

        MyThread2 thread1 = new MyThread2() ;
        thread1.name = "A" ;

        MyThread2 thread2 = new MyThread2() ;
        thread2.name = "B" ;

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;
    }
}

class MyThread2 extends Thread {

    String name ;

    public void run() {

        for(int i = 0 ; i < 10 ; i++) {
            System.out.println("Hello from thread " + name) ;
        }
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

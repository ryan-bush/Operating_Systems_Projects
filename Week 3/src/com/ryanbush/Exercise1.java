package com.ryanbush;

public class Exercise1 {
    public static void main(String args []) throws Exception {

        MyThread6.count = 0 ;

        MyThread6 thread1 = new MyThread6() ;
        thread1.name = "A" ;

        MyThread6 thread2 = new MyThread6() ;
        thread2.name = "B" ;

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;

        System.out.println("MyThread6.count = " + MyThread6.count) ;
    }
}

class MyThread6 extends Thread {
    volatile static int count ;
    String name ;
    public void run() {
        for(int i = 0 ; i < 10 ; i++) {
            delay();
            int x = count ;
            System.out.println("Thread " + name + " read " + x) ;
            delay() ;
            count = x + 1 ;
            System.out.println("Thread " + name + " wrote " + (x + 1)) ;
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

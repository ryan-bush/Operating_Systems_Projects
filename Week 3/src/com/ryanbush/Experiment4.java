package com.ryanbush;

public class Experiment4 {
    public static void main(String args []) throws Exception {

        MyThread4.count = 0 ;

        MyThread4 thread1 = new MyThread4();
        MyThread4 thread2 = new MyThread4();

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;

        System.out.println("MyThread4.count = " + MyThread4.count) ;
    }
}

class MyThread4 extends Thread {

    volatile static int count ;

    public void run() {

        for(int i = 0 ; i < 1000000000 ; i++) {
            count = count + 1;
        }
    }
}

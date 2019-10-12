package com.ryanbush;

public class Exercise2 {
    public static void main(String args []) throws Exception {

        MyThread8.q = new Queue() ;

        MyThread8 thread1 = new MyThread8() ;
        thread1.name = "A" ;

        MyThread8 thread2 = new MyThread8() ;
        thread2.name = "B" ;

        thread1.start() ;
        thread2.start() ;

        thread2.join() ;
        thread1.join() ;
    }
}

class MyThread8 extends Thread {

    volatile static Queue q ;

    String name ;

    public void run() {

        for(int i = 0 ; i < 1000000 ; i++) {
            q.add("message " + i) ;
            System.out.println("Thread " + name +
                    " added message " + i) ;
        }
    }
}


class Queue {

    volatile Node front, back ;

    public void add(String data) {
        if (front != null) {
            back.next = new Node(data) ;
            back = back.next ;
        }
        else {
            front = new Node(data) ;
            back = front ;
        }
    }

    public String rem() {
        // returns null if queue empty
        String result = null ;
        if (front != null)  {
            result = front.data ;
            front   = front.next ;
        }
        return result ;
    }
}

class Node {
    Node(String data) {
        this.data = data ;
    }

    String data ;
    Node next ;
}

package com.company;

public class Experiment3 {
    public static void main(String args []) {

        MyOtherClass.b = "my string value" ;

        MyOtherClass object1 = new MyOtherClass() ;
        object1.a = 42 ;

        MyOtherClass object2 = new MyOtherClass() ;
        object2.a = 23 ;

        System.out.println("Fields of object1:") ;
        object1.printMyFields() ;

        System.out.println("Fields of object2:") ;
        object2.printMyFields() ;
    }
}

class MyOtherClass {
    int a ;
    static String b ;

    void printMyFields() {

        System.out.println("Field a is: " + a) ;
        System.out.println("Field b is: " + b) ;
    }
}

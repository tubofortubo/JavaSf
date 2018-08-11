package com.tubo.trie;

public class A {
    A(int i){
        System.out.println(i);
    }
}

class  B{
    A a1=new A(1);
    B(){
        System.out.println("h()");
        a3=new A(2);
    }
    A a2=new A(3);
    void f(){
        System.out.println("fun()");
    }
    A a3=new A(4);
    public static void main(String[] args){
//        B b=new  B();
//        b.f();
        Runnable r;
        Thread t=new Thread(  r=()->System.out.println("开始"));
        t.start();

    }

}

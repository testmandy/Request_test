package com.test.practice;

public class ThreadTest{
    Thread t1 = new Thread();

    private Runnable run1 = new Runnable() {
        @Override
        public void run() {
            synchronized (ThreadTest.class){
                System.out.println("run1 is ready and waiting......");
                try {
                    ThreadTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run1 is running......");
                System.out.println("run1 is dead......");

            }
        }
    };

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.t1.start();
    }
}

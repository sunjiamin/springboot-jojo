package com.sun.jojo.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-06-08 10:16
 */
public class Increment {
    public int getI() {
        return i;
    }

    private int i;

    private PlainLock lock = new PlainLock();
    ReentrantLock reentrantLock = new ReentrantLock();

    public void increment(){
        lock.lock();
        //reentrantLock.lock();
        i++;
        lock.unlock();
        //reentrantLock.unlock();
    }
    static Increment increment = new Increment();

    public static void test(int threadNum, int loopTimes) {

        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < loopTimes; i1++) {
                        increment.increment();
                    }
                }
            });
            t.start();
            threads[i] = t;

        }

        //main线程等待其他线程都执行完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadNum + "个线程，循环" + loopTimes + "次结果：" + increment.getI());

    }

    public static void main(String[] agrs){
        test(20, 1);
        System.out.println("-------------------");
        test(20, 10);
        System.out.println("-------------------");
        test(20, 100);
        System.out.println("-------------------");
        //test(20, 1000);
        System.out.println("-------------------");
        //test(20, 10000);
        System.out.println("-------------------");
        ///test(20, 100000);
        System.out.println("-------------------");
       // test(20, 1000000);
    }
}

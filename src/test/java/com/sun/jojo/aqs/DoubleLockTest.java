package com.sun.jojo.aqs;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-06-08 11:00
 */
public class DoubleLockTest {

    public static void main(String[] agrs){
        DoubleLockTest doubleLockTest  = new DoubleLockTest();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(doubleLockTest::test);
            
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private  DoubleLock doubleLock = new DoubleLock();
    public   void test(){
        doubleLock.lock();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doubleLock.unlock();
    }



}

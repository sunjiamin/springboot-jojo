package com.sun.jojo.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * description: 独占同步工具锁
 *
 * @author sunjiamin
 * @date 2018-06-08 10:08
 */
public class PlainLock {
    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 自定义尝试获取锁的规则
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            System.out.println("current thread name:" + Thread.currentThread().getName() + " state:" + getState());
            return compareAndSetState(0,1);
        }

        /**
         * 自定义释放锁的规则
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        /**
         * 表示当前是否有线程已经获取到了同步状态
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private Sync sync = new Sync();

    public void lock(){
        sync.acquire(1);
    }

    public void unlock(){
        sync.release(1);
    }
}

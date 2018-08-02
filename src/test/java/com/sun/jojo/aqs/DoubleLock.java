package com.sun.jojo.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * description:共享式同步工具
 *
 * @author sunjiamin
 * @date 2018-06-08 10:54
 */
public class DoubleLock {
//    private static class Sync extends AbstractQueuedSynchronizer {
//        public Sync() {
//            super();
//            //设置同步状态的值
//            setState(2);
//        }
////        public Sync(int arg) {
////            super();
////            //设置同步状态的值
////            setState(arg);
////        }
//
//        @Override
//        protected int tryAcquireShared(int arg) {
//            while(true){
//                int cur = getState();
//                int next = getState()-arg;
//                if(compareAndSetState(cur,next)){
//                    return next;
//                }
//            }
//        }
//
//        @Override
//        protected boolean tryReleaseShared(int arg) {
//            while(true){
//                int cur = getState();
//                int next = getState()+arg;
//                if(compareAndSetState(cur,next)){
//                    return true;
//                }
//            }
//        }
//
//
//    }
////
////    public DoubleLock( ) {
////        //this.sync =  new Sync();
////    }
////
////    public DoubleLock(int arg) {
////        //this.sync =  new Sync();
////    }
//
//    private Sync sync  =  new Sync();
//
//    public void lock() {
//        System.out.println(Thread.currentThread().getName() + " 进来了。。。");
//        sync.acquireShared(1);
//    }
//
//    public void unlock() {
//        System.out.println(Thread.currentThread().getName() + " 出去了。。。");
//        sync.releaseShared(1);
//    }
private static class Sync extends AbstractQueuedSynchronizer {

    public Sync() {
        super();
        setState(2);    //设置同步状态的值
    }

    @Override
    protected int tryAcquireShared(int arg) {
        while (true) {
            int cur = getState();
            int next = getState() - arg;
            if (compareAndSetState(cur, next)) {
                return next;
            }
        }
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        while (true) {
            int cur = getState();
            int next = cur + arg;
            if (compareAndSetState(cur, next)) {
                return true;
            }
        }
    }
}

    private Sync sync = new Sync();

    public void lock() {
        System.out.println(Thread.currentThread().getName() + " 进来了。。。");
        sync.acquireShared(1);
    }

    public void unlock() {
        System.out.println(Thread.currentThread().getName() + " 出去了。。。");
        sync.releaseShared(1);
    }
}

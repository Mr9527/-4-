package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static final int MAX_COUNT = 1746137;
    private static Integer nowCnt = 0;

    static class Thread1 extends Thread {

        private ReentrantLock lock;

        private Condition condition1;

        private Condition condition2;

        private Condition condition3;


        public Thread1(ReentrantLock lck, Condition con1, Condition con2, Condition con3) {
            lock = lck;
            condition1 = con1;
            condition2 = con2;
            condition3 = con3;
        }

        @Override
        public void run() {

            try {
                lock.lock();
                while (nowCnt < MAX_COUNT) {
                    System.out.print("thread-1: ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(nowCnt + " ");
                        ++nowCnt;
                    }
                    System.out.println();
                    //线程2激活
                    condition2.signal();
                    //线程1
                    condition1.await();
                }
                condition2.signal();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                lock.unlock();
            }

        }
    }

    static class Thread2 extends Thread {

        private ReentrantLock lock;

        private Condition condition1;

        private Condition condition2;

        private Condition condition3;


        public Thread2(ReentrantLock lck, Condition con1, Condition con2, Condition con3) {
            lock = lck;
            condition1 = con1;
            condition2 = con2;
            condition3 = con3;
        }

        @Override
        public void run() {


            try {
                lock.lock();
                while (nowCnt < MAX_COUNT) {
                    System.out.print("thread-2: ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(nowCnt + " ");
                        ++nowCnt;
                    }
                    System.out.println();
                    //线程2激活
                    condition3.signal();
                    //线程3等待
                    condition2.await();
                }

                condition3.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }
    }

    static class Thread3 extends Thread {

        private ReentrantLock lock;

        private Condition condition1;

        private Condition condition2;

        private Condition condition3;


        public Thread3(ReentrantLock lck, Condition con1, Condition con2, Condition con3) {
            lock = lck;
            condition1 = con1;
            condition2 = con2;
            condition3 = con3;
        }

        @Override
        public void run() {

            try {
                lock.lock();
                while (nowCnt < MAX_COUNT) {
                    System.out.print("thread-3: ");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(nowCnt + " ");
                        ++nowCnt;
                    }
                    System.out.println();
                    //线程1激活
                    condition1.signal();
                    condition3.await();
                }

                condition1.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }
    }

    public static void main(String args[]) {

        try {

            ReentrantLock lock = new ReentrantLock();
            Condition condition1 = lock.newCondition();
            Condition condition2 = lock.newCondition();
            Condition condition3 = lock.newCondition();
            Thread1 thread1 = new Thread1(lock, condition1, condition2, condition3);
            Thread2 thread2 = new Thread2(lock, condition1, condition2, condition3);
            Thread3 thread3 = new Thread3(lock, condition1, condition2, condition3);

            thread1.start();
            Thread.sleep(50);
            thread2.start();
            Thread.sleep(50);
            thread3.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

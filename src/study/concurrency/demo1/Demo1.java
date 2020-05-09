package study.concurrency.demo1;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        Thread notifyThread = new NotifyThread(waitThread);
        waitThread.start();
        notifyThread.start();

        Thread.sleep(5000);
    }

    static class NotifyThread extends Thread {
        Object mObject;
        public NotifyThread(Object object) {
            mObject = object;
        }

        @Override
        public void run() {
            super.run();
            synchronized (Demo1.class) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mObject.notify();
            }

        }
    }

    static class WaitThread extends Thread {

        @Override
        public void run() {
            super.run();
            synchronized(Demo1.class) {
                try {
                    System.out.println("before wait");
                    this.wait();
                    System.out.println("after wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}

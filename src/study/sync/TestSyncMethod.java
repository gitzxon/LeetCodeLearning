package study.sync;

public class TestSyncMethod {

    public synchronized String a() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "A";
    }
    public synchronized String b() {
        return "B";
    }
    public synchronized void c() {  }

}

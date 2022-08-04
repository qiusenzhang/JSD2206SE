package thread;

public class SyncDemo5 {
    public static void main(String[] args) {
        Boos boo = new Boos();
        Thread t1 = new Thread(){
            public void run(){
                boo.methodA();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                boo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}


class Boos {
    public synchronized void methodA() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + "正在执行方法A...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println(t.getName() + "方法A执行完毕！");
    }

    public void methodB() {
        synchronized (this) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "正在执行方法B...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println(t.getName() + "方法B执行完毕！");

        }
    }
}

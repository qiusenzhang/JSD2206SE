package thread;

/**
 * 多线程
 * 多线程可以并发执行多个代码片段
 * 并发：多个线程宏观上是一起执行，微观上时走走停停的
 *
 * 第一种创建线程的方式：
 * 1.继承Thread
 * 2.重写run方法
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new Mythread1();
        Thread t2 = new Mythread2();
        //线程的启动要调用start方法，而不是直接调用run方法
        t1.start();
        t2.start();

    }
}
class Mythread1 extends Thread{
    public void run(){
        for (int i = 0; i<1000;i++){
            System.out.println("你是谁啊？");
        }
    }
}
class Mythread2 extends Thread{
    public void run(){
        for (int i = 0;i<1000;i++){
            System.out.println("开门，查水表的！");
        }
    }
}
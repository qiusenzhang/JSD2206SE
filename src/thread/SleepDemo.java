package thread;

/**
 * 线程的静态方法：
 * static void sleep(long ms)
 * 该方法可以让运行这个方法的线程处于阻塞状态指定毫秒
 */
import java.util.Scanner;
public class SleepDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("程序开始了");
        System.out.println("请输入一个数字：");
            for (int i =scanner.nextInt(); i > 0; i--) {
                System.out.println(i);
                try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            }

        System.out.println("程序结束了");
    }
}

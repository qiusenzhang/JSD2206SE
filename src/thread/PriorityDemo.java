package thread;

/**
 * 线程的优先级
 *
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            public void run(){
                for (int i = 0;i<1000;i++){
                    System.out.println("min");
                }
            }
        };
        Thread nor = new Thread(){
            public void run(){
                for (int i = 0;i<1000;i++){
                    System.out.println("nor");
                }
            }
        };
        Thread max = new Thread(){
            public void run(){
                for (int i = 0;i<1000;i++){
                    System.out.println("max");
                }
            }
        };

        min.setPriority(Thread.MIN_PRIORITY);//设置为最小优先级
        max.setPriority(Thread.MAX_PRIORITY);//设置为最高优先级
        min.start();
        nor.start();
        max.start();
    }
}

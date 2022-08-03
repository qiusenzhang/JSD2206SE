package thread;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
        public void run(){
        for (int i = 0;i<1000;i++){
            System.out.println("你是谁啊？");
        }
        }
        };

//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0;i<1000;i++){
//                    System.out.println("我是查水表的");
//                }
//            }
//        };
//        Thread t2 = new Thread(r2);

        Thread t2 = new Thread(()->{
            for (int i = 0;i<1000;i++){
                System.out.println("我是查水表的");
            }
        });
        t1.start();
        t2.start();
        }
    }


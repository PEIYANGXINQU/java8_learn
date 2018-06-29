package chapter2_行为参数化;

public class Lambda_runnable_demo {
    public static void main(String[] args){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("cris");
            }
        });
        t.start();

        Thread t1 = new Thread(() -> {
            System.out.println("hello");
        });
        t1.start();
    }



}

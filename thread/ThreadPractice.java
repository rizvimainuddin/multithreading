package thread;
class MyThread implements Runnable{
    public MyThread() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i=1;i<=15;i++){
            System.out.println(i);
        }
    }
}
public class ThreadPractice {
    public static void main(String[] args) {
        MyThread th = new MyThread();

    }
}

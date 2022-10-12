
class Worker extends Thread  {

    public void run(){
        System.out.println("This is Thread: "+this.getId());
    }
}

class RunnableWorker implements Runnable  {
    @Override
    public void run(){
        System.out.println("Runnable Thread Running");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Worker worker1=new Worker();
        Worker worker2=new Worker();
        worker1.start();
        worker2.start();
        worker1.join();
        System.out.println("Thread 1: "+worker1.getId());
        System.out.println("Thread 2: "+worker2.getId());
//        worker1.sleep(5000);
//        worker2.sleep(5000);


        new Thread(new RunnableWorker()).start();
        new Thread(()-> System.out.println("Runnable Lambda")).start();


    }
}
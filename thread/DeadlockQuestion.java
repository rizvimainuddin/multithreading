package thread;
class Number{
    int number;
    Object lock;
    public Number(){
        this.number=0;
        this.lock=new Object();
    }
    public Number(int number){
        this.number=number;
        this.lock=new Object();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }
}
class Calculate{
    public int addTwo(Number number1, Number number2){
        synchronized(number1.getLock()){
            synchronized (number2.getLock()){
                int n=number1.getNumber();
                number1.setNumber(number2.getNumber());
                number2.setNumber(n);
                return number1.getNumber()+n;
            }
        }

    }
}
public class DeadlockQuestion {
    public static void main(String[] args) {
        Number number1=new Number(25);
        Number number2=new Number(45);
        Calculate calculate=new Calculate();
        Thread thread1=new Thread(()->{
            for(int i=0;i<100;i++){

                calculate.addTwo(number1,number2);
            }
        });
        Thread thread2=new Thread(()->{
            for(int i=0;i<100;i++){

                calculate.addTwo(number1,number2);
            }
        });
        System.out.println("done");
        thread1.start();
        thread2.start();
    }
}

package thread;
class Table{
    synchronized void display(int number){
        for (int i=1;i<=10;i++){
            System.out.println(number*i);
        }
    }
}

class Thread1 extends Thread{
    Table table;

    public Thread1(Table t) {
        this.table = t;
    }

    @Override
    public void run() {
        table.display(5);
    }
}
class Thread2 extends Thread{
    Table table;

    public Thread2(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        table.display(6);
    }
}
public class SynchronizedProgram {
    public static void main(String[] args) {
        Table table = new Table();
        Thread1 thread1 = new Thread1(table);
        Thread2 thread2 = new Thread2(table);

        thread1.start();
        thread2.start();

    }
}

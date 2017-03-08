package scheduler;

public class Scheduler implements Runnable{

    public Scheduler() {
        new Thread(this,"Scheduler").start();
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}

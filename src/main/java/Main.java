import algorithms.FCFS;
import scheduler.Scheduler;

public class Main {

    public static void main(String[] args) {

        FCFS fcfs = new FCFS();
        Scheduler scheduler = new Scheduler(0.55, fcfs);
    }
}

import algorithms.FCFS;
import scheduler.Scheduler;

/**
 * Created by Bartek on 08.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        FCFS fcfs = new FCFS();

        Scheduler scheduler = new Scheduler(fcfs);
    }
}

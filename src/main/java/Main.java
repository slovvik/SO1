import algorithms.Algorithm;
import algorithms.FCFS;
import scheduler.Scheduler;
import statistics.Statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Statistics statistics = new Statistics();
        FCFS fcfs = new FCFS(statistics);
        List<Algorithm> algorithmList = new ArrayList<>();
        algorithmList.add(fcfs);
        statistics.setAlgorithms(algorithmList.toArray(new Algorithm[algorithmList.size()]));
        Scheduler scheduler = new Scheduler(0.55, fcfs);

        Thread.sleep(20000);
        System.out.println(statistics.showStats());
    }
}

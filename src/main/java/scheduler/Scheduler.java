package scheduler;

import algorithms.Algorithm;
import process.Process;

import java.util.concurrent.ThreadLocalRandom;

public class Scheduler implements Runnable {

    private static int NUMBER_OF_PROCESSES = 20;
    private static int NUMBER_OF_TEST_DATA = 1;
    private static int FROM = 250;
    private static int TO = 500;
    private static int WAIT_FROM = 1000;
    private static int WAIT_TO = 1500;

    private Algorithm[] algorithms;
    private double probability;

    public Scheduler(double probability, Algorithm... algorithms) {
        this.probability = probability;
        this.algorithms = algorithms;
        new Thread(this, "Scheduler").start();
    }

    @Override
    public void run() {
        int allProcessesDelivered = 0;
        int timer = 0;
        int allProcesses = NUMBER_OF_PROCESSES * NUMBER_OF_TEST_DATA;
        while (allProcessesDelivered != allProcesses) {
            allProcessesDelivered++;
            Process process = new Process(allProcessesDelivered, getRandomPhaseProcessor(FROM, TO), timer);
            if (shouldAddNow() || allProcessesDelivered == 1) {
                process.setAddedWithOutWait(true);
                process.setWaitTimeBeforeAdded(0);
                addProcess(process);
                System.out.println("Added process: " + process.getProcessID());
            } else {
                int waitTime = getRandomWaitTime(WAIT_FROM, WAIT_TO);
                process.setAddedWithOutWait(false);
                process.setWaitTimeBeforeAdded(waitTime);
                process.setAddedTime(process.getAddedTime() + waitTime);
                addAfterWaitTime(process, waitTime);
                System.out.println("Added process: " + process.getProcessID());
                timer += waitTime;
            }
        }
        schedulerFinished();
    }

    private void schedulerFinished() {
        for (Algorithm algorithm : algorithms) {
            algorithm.setDone(true);
        }
    }

    private boolean shouldAddNow() {
        double probability = ThreadLocalRandom.current().nextDouble();
        return probability < this.probability;
    }

    private int getRandomPhaseProcessor(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
//        return r
    }

    private int getRandomWaitTime(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    private void addProcess(Process process) {
        for (Algorithm algorithm : algorithms) {
            algorithm.addProcess(process);
        }
    }

    private void addAfterWaitTime(Process process, int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addProcess(process);
    }
}

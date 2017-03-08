package scheduler;

import algorithms.Algorithm;
import process.Process;

import java.util.concurrent.ThreadLocalRandom;

public class Scheduler implements Runnable{

    private static int NUMBER_OF_PROCESSES = 20;
    private static int NUMBER_OF_TEST_DATA = 50;
    private static int FROM = 5;
    private static int TO = 500;

    private Algorithm[] algorithms;
    private boolean isDone;

    public Scheduler(Algorithm ... algorithms) {
        this.algorithms = algorithms;
        isDone = false;
        new Thread(this,"Scheduler").start();
    }

    @Override
    public void run() {
        int allProcessesDelivered = 0;
        int timer = 0;
        int allProcesses = NUMBER_OF_PROCESSES * NUMBER_OF_TEST_DATA;
        while (allProcessesDelivered != allProcesses) {
            allProcessesDelivered++;
            Process process = new Process(getRandomPhaseProcessor(FROM, TO), timer);
            timer += process.getPhaseProcessor();
            if (shouldAddNow()) {
                addProcess(process);
            }
            else {
                int waitTime = getRandomWaitTime(FROM, TO);
                addAfterWaitTime(process, waitTime);
                timer += waitTime;
            }
        }
        isDone = true;
    }

    private boolean shouldAddNow() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    private static int getRandomPhaseProcessor(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }
    private static int getRandomWaitTime(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    private void addProcess(Process process) {
        for (Algorithm algorithm : algorithms) {
            algorithm.addProcess(process);
        }
    }

    private void addAfterWaitTime(Process process, int waitTime) {
        try {
            this.wait(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addProcess(process);
    }
}

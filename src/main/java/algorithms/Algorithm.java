package algorithms;

import process.Process;
import statistics.Statistics;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Algorithm {

    Queue<Process> processQueue;
    boolean isDone;
    boolean threadIsDone;
    Statistics statistics;

    Algorithm(Statistics statistics) {
        this.processQueue = new ConcurrentLinkedQueue<>();
        this.isDone = false;
        this.threadIsDone = false;
        this.statistics = statistics;
    }

    void waitForProcessToFinish(Process process) {
        try {
            Thread.sleep(process.getPhaseProcessor());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean canShow() {
        return processQueue.size() == 0 && isDone;
    }

    public void addProcess(Process process) {
        processQueue.add(process);
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

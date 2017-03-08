package algorithms;

import process.Process;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Algorithm {

    Queue<Process> processQueue;
    boolean isDone;
    boolean threadIsDone;

    Algorithm() {
        this.processQueue = new ConcurrentLinkedQueue<>();
        this.isDone = false;
        this.threadIsDone = false;
    }

    public void waitForProcessToFinish(Process process) {
        try {
            Thread.sleep(process.getPhaseProcessor());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

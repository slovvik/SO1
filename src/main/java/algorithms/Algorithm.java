package algorithms;

import process.Process;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {

    protected Queue<Process> processQueue;
    protected boolean isDone;

    public Algorithm(boolean isDone) {
        this.processQueue = new LinkedList<>();
        this.isDone = isDone;
    }

    public void addProcess(Process process) {
        processQueue.add(process);
    }
}

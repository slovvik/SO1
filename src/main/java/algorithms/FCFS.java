package algorithms;

import process.Process;

public class FCFS extends Algorithm implements Runnable {

    public FCFS() {
        super();
        new Thread(this, getClass().getName()).start();
    }

    @Override
    public void run() {
        int processFinished = 0;
        while (true) {
            if (processQueue.size() != 0) {

                Process process = processQueue.poll();
                waitForProcessToFinish(process);
                processFinished += process.getPhaseProcessor();
                process.setFinishTime(processFinished);
                System.out.println("Processes in queue: " + (processQueue.size() + 1));
                System.out.println(process);
            } else if (processQueue.size() == 0 && isDone) {
                break;
            }

        }
        System.out.println("Average time: " + processFinished / 20);
    }
}

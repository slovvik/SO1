package algorithms;

import process.Process;
import statistics.Statistics;

public class FCFS extends Algorithm implements Runnable {

    public FCFS(Statistics statistics) {
        super(statistics);
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
        statistics.getStatisticsList().add("FCFS average time: " + processFinished / 20);
    }
}

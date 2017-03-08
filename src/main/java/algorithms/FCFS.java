package algorithms;

public class FCFS extends Algorithm implements Runnable {

    public FCFS(boolean isDone) {
        super(isDone);
    }

    @Override
    public void run() {
        while (!isDone && processQueue.size() == 0) {

        }
    }
}

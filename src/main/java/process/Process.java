package process;

/**
 * Created by Bartek on 08.03.2017.
 */
public class Process {

    private int processID;
    private int phaseProcessor;
    private int addedTime;
    private int waitTimeBeforeAdded;
    private int finishTime;
    private boolean addedWithOutWait;

    public Process(int processID, int phaseProcessor, int addedTime) {
        this.processID = processID;
        this.phaseProcessor = phaseProcessor;
        this.addedTime = addedTime;
    }

    public int getPhaseProcessor() {
        return phaseProcessor;
    }

    public void setPhaseProcessor(int phaseProcessor) {
        this.phaseProcessor = phaseProcessor;
    }

    public int getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(int addedTime) {
        this.addedTime = addedTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processID=" + processID +
                ", phaseProcessor=" + phaseProcessor +
                ", addedTime=" + addedTime +
                ", waitTimeBeforeAdded=" + waitTimeBeforeAdded +
                ", finishTime=" + finishTime +
                ", addedWithOutWait=" + addedWithOutWait +
                '}';
    }

    public boolean isAddedWithOutWait() {
        return addedWithOutWait;
    }

    public void setAddedWithOutWait(boolean addedWithOutWait) {
        this.addedWithOutWait = addedWithOutWait;
    }

    public int getWaitTimeBeforeAdded() {
        return waitTimeBeforeAdded;
    }

    public void setWaitTimeBeforeAdded(int waitTimeBeforeAdded) {
        this.waitTimeBeforeAdded = waitTimeBeforeAdded;
    }

    public int getProcessID() {
        return processID;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
}

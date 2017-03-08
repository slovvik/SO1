package process;

/**
 * Created by Bartek on 08.03.2017.
 */
public class Process {

    private int phaseProcessor;
    private int addedTime;

    public Process(int phaseProcessor, int addedTime) {
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
}

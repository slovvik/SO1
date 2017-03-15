package statistics;

import algorithms.Algorithm;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Statistics {

    private List<String> statisticsList;

    private Algorithm[] algorithms;

    public Statistics() {
        statisticsList = new CopyOnWriteArrayList<>();
    }

    public String showStats() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean canShow = false;

        while (!canShow) {
            for (Algorithm algorithm : algorithms) {
                canShow = algorithm.canShow();
                if (!canShow) break;
            }
        }
        statisticsList.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public List<String> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<String> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public Algorithm[] getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(Algorithm[] algorithms) {
        this.algorithms = algorithms;
    }

}

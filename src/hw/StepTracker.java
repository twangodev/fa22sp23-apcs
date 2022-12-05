package hw;

// James Ding
public class StepTracker {

    private int minSteps;
    private int activeDays;
    private int totalSteps;

    public StepTracker(int minSteps) {
        this.minSteps = minSteps;
        activeDays = 0;
        totalSteps = 0;
    }

    public void addDailySteps(int steps) {
        totalSteps += steps;
        if (steps >= minSteps) {
            activeDays++;
        }
    }

    public int activeDays() {
        return activeDays;
    }

    public double averageSteps() {
        return (double) totalSteps / activeDays;
    }

}

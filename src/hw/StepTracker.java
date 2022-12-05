package hw;

// James Ding
public class StepTracker {

    private int minSteps;
    private int totalDays;
    private int activeDays;
    private int totalSteps;

    public StepTracker(int minSteps) {
        this.minSteps = minSteps;
        totalDays = 0;
        activeDays = 0;
        totalSteps = 0;
    }

    public void addDailySteps(int steps) {
        totalSteps += steps;
        totalDays++;
        if (steps >= minSteps) {
            activeDays++;
        }
    }

    public int activeDays() {
        return activeDays;
    }

    public double averageSteps() {
        if (totalDays == 0) {
            return 0;
        }
        return (double) totalSteps / totalDays;
    }

    public static void main(String[] args) {
        StepTracker tr = new StepTracker(10000);
        System.out.println("Active days: " + tr.activeDays());
        System.out.println("Average steps: " + tr.averageSteps());
        tr.addDailySteps(9000);
        tr.addDailySteps(5000);
        System.out.println("Active days: " + tr.activeDays());
        System.out.println("Average steps: " + tr.averageSteps());
        tr.addDailySteps(13000);
        System.out.println("Active days: " + tr.activeDays());
        System.out.println("Average steps: " + tr.averageSteps());
        tr.addDailySteps(23000);
        tr.addDailySteps(1111);
        System.out.println("Active days: " + tr.activeDays());
        System.out.println("Average steps: " + tr.averageSteps());
    }

}

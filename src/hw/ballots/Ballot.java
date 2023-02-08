package hw.ballots;

import java.util.ArrayList;
import java.util.Arrays;

public class Ballot {

    ArrayList<String> myChoice = new ArrayList<>();

    public Ballot(String[] list) {
        myChoice.addAll(Arrays.asList(list));
    }

    public String firstChoiceFrom(ArrayList<String> candidates) {
        for (String candidate : candidates) {
            if (myChoice.contains(candidate)) {
                return candidate;
            }
        }
        return null;
    }

}

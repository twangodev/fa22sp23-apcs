package hw.stones;

import java.util.HashMap;

// James Ding
public class DingStones extends StonesPlayer {

    public DingStones() {
        super("James Ding");
    }

    public int totalPossibleSolutions(int i, StonesGame game) {
        StonesGame gameCopy = StonesGame.copy(game, false);
        gameCopy.stoneCount -= i;
        gameCopy.previous.move(gameCopy);

        if (gameCopy.stoneCount < 1) {
            return 1;
        } else {
            int total = 0;
            for (int j = 1; j <= 3; j++) {
                if (gameCopy.stoneCount - j >= 0) {
                    total += totalPossibleSolutions(j, gameCopy);
                }
            }
            return total;
        }
    }

    public int move(StonesGame game) {
        HashMap<Integer, Integer> results = new HashMap<>();
        for (int i : StonesGame.possibleTakes) {results.put(i, 0);}
        for (int take : StonesGame.possibleTakes) {
            results.put(take, totalPossibleSolutions(take, game));
        }

        int highestKey = 0;
        int highestSolutionCount = 0;
        for (int i : StonesGame.possibleTakes) {
            int solutionCount = results.get(i);
            game.announce("Possible take: " + i + " | " + solutionCount + " solutions.");
            if (results.get(i) > highestSolutionCount) {
                highestKey = i;
                highestSolutionCount = solutionCount;
            }
        }

        if (highestKey == 0) return (int) (Math.random() * StonesGame.maxTake) + 1;
        return highestKey;
    }


}

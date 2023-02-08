package hw.ballots;

import java.util.ArrayList;
import java.util.Arrays;

public class VoterBallots {

    private ArrayList<Ballot> ballotList;
    private ArrayList<String> candidateList;

    public VoterBallots() {
        ballotList = new ArrayList<>();
        candidateList = new ArrayList<>();
    }

    public void addBallot(Ballot ballot) {
        ballotList.add(ballot);
    }

    private int numFirstVotes(String candidate, ArrayList<Ballot> ballots) {
        int count = 0;
        for (Ballot ballot : ballots) {
            if (ballot.firstChoiceFrom(candidateList).equals(candidate)) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<String> candidatesWithFewest(ArrayList<String> candidateList) {
        ArrayList<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (String candidate : candidateList) {
            int numVotes = numFirstVotes(candidate, ballotList);
            if (numVotes < min) {
                min = numVotes;
                result.clear();
                result.add(candidate);
            } else if (numVotes == min) {
                result.add(candidate);
            }
        }
        return result;
    }

    public ArrayList<String> getCandidateList() {
        return candidateList;
    }

    public void runRound() {
        for (String candidate : candidateList) {
            System.out.println(candidate + ": " + numFirstVotes(candidate, ballotList));
        }

        System.out.println("Candidates eliminated this round: " + candidatesWithFewest(candidateList));
        candidateList.removeAll(candidatesWithFewest(candidateList));
    }

    public void addCandidates(String[] string) {
        candidateList = new ArrayList<>();
        candidateList.addAll(Arrays.asList(string));
    }

    public static void main(String[] args) {
        String[][] votes= {
                {"Chris", "Jamie", "Pat", "Sandy"},
                {"Chris", "Pat", "Sandy","Jamie"},
                {"Chris", "Sandy", "Pat","Jamie"},
                {"Pat", "Jamie", "Sandy","Chris"},
                {"Pat", "Sandy","Chris", "Jamie"},
                {"Sandy","Pat", "Jamie", "Chris"},
                {"Jamie","Sandy","Pat",  "Chris"}
        };

        VoterBallots election = new VoterBallots();
        for (String[] sl : votes) {
            election.addBallot(new Ballot(sl));
        }
        election.addCandidates(votes[0]);
        while (election.getCandidateList().size()>1) {
            election.runRound();
            System.out.println("Current Candidates: " + election.getCandidateList());
        }
    }

}

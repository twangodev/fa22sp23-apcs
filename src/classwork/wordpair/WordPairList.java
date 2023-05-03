package classwork.wordpair;

import java.util.ArrayList;

public class WordPairList {

    private ArrayList<WordPair> allPairs;

    public WordPairList(String[] words) {
        allPairs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }

    public int numMatches() {
        int count = 0;
        for (WordPair pair: allPairs) {
            if (pair.getFirst().equals(pair.getSecond())) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] wordNums =  {"one", "two", "three"};
        WordPairList exampleOne = new WordPairList(wordNums);
        System.out.println(exampleOne.allPairs.toString());

        String[] phrase = {"the", "more", "the", "merrier"};
        WordPairList exampleTwo = new WordPairList(phrase);
        System.out.println(exampleTwo.allPairs.toString());

        String[] moreWords = {"the", "red", "fox", "the", "red"};
        WordPairList exampleThree = new WordPairList(moreWords);
        System.out.println(exampleThree.allPairs.toString());
        System.out.println(exampleThree.numMatches());
    }

}

package classwork.wordpair;

public class WordPair {

    private final String first;
    private final String second;

    public WordPair (String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

}

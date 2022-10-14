package hw;

import java.util.Scanner;

// James Ding
public class BibleStory {

    private String title, summary, time, characters, verses, fullStory, trivia;

    public BibleStory(String title, String summary, String time, String characters, String verses, String fullStory) {
        this.title = title;
        this.summary = summary;
        this.time = time;
        this.characters = characters;
        this.verses = verses;
        this.fullStory = fullStory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getVerses() {
        return verses;
    }

    public void setVerses(String verses) {
        this.verses = verses;
    }

    public String getFullStory() {
        return fullStory;
    }

    public void setFullStory(String fullStory) {
        this.fullStory = fullStory;
    }

    public String getTrivia() {
        return trivia;
    }

    public void setTrivia(String trivia) {
        this.trivia = trivia;
    }

    public void tellStory() {
        System.out.println("The story begins: \n\n" + fullStory);
    }

    @Override
    public String toString() {
        return "BibleStory{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", time='" + time + '\'' +
                ", characters='" + characters + '\'' +
                ", verses='" + verses + '\'' +
                ", fullStory='" + fullStory + '\'' +
                ", trivia='" + trivia + '\'' +
                '}';
    }

    public static void main(String[] args) {
        BibleStory story = new BibleStory(
                "Creation",
                "The first story in the bible describing how God created the world we know of today",
                "~4000 B.C",
                "God, Adam, and Eve",
                "Genesis 1:1-2:3",
                "Day 1: God creates the day and night.\n" +
                        "Day 2: God creates the waters and the sky.\n" +
                        "Day 3: God creates the land, seas, plants, and trees.\n" +
                        "Day 4: God creates the rest of space.\n" +
                        "Day 5: God creates the living creatures.\n" +
                        "Day 6: God creates Adam and Eve.\n" +
                        "Day 7: God rests"
                );
        Scanner kb = new Scanner(System.in);
        story.tellStory();

        // Trivia
        story.setTrivia("7");
        System.out.print("Trivia: How many days did it take for this story to finish: ");
        String response = kb.nextLine();
        String validity;
        if (response.equals(story.getTrivia())) validity = "Correct";
        else validity = "Incorrect";
        System.out.println(validity);
    }

}

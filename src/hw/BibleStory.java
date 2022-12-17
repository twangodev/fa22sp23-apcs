package hw;

// James Ding
public class BibleStory {

    private String title, year, summary, story, characters, verses;

    public BibleStory(String title, String year, String summary, String story, String characters, String verses) {
        this.title = title;
        this.year = year;
        this.summary = summary;
        this.story = story;
        this.characters = characters;
        this.verses = verses;
    }

    public static void main(String[] args) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
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

    /**
     * Prints the story with verses
     */
    public void tellStory() {
        System.out.println(story);
        System.out.println("This story can be found from verse(s):" + verses);
    }

    @Override
    public String toString() {
        return "BibleStory{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

}

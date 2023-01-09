package hw;

// James Ding
public class LineEditor {

    private String myLine;

    public void insert(String str, int index) {
        myLine = myLine.substring(0, index) + str + myLine.substring(index);
    }

    public void delete(String str) {
        myLine = myLine.replace(str, "");
    }

    public void deleteAll(String str) {
        myLine = myLine.replaceAll(str, "");
    }

    public LineEditor(String str) {
        myLine = str;
    }

    @Override
    public String toString() {
        return myLine;
    }

    public static void main(String[] args) {
        LineEditor myLine = new LineEditor ("Computer Science");
        myLine.insert("A.P.", 0);
        System.out.println(myLine);
        myLine.insert(" is best", 16);
        System.out.println(myLine);
        myLine.delete("Com");
        System.out.println(myLine);
        myLine.delete("Java");
        System.out.println(myLine);
        myLine.deleteAll("er");
        System.out.println(myLine);
    }

}

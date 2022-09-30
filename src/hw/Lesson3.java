package hw;

public class Lesson3 {

    public void problem1() {
        int argh = 129;
        System.out.println("The number of rabbits is " + argh + ".");
    }

    public void problem2() {
        String p = "Groovy Dude";
        System.out.println(p.toUpperCase()); // GROOVY DUDE
    }

    public void problem3() {
        String g = "Computer Science is for nerds";
        System.out.println(g.toLowerCase());
    }

    public void problem4() {
        String c;
        String m = "The Gettysburg Address";
        c = m.substring(4); // Gettysburg Address
    }

    public void problem5() {
        String b = "Four score and seven years ago,";
        String c = b.substring(7, 12); // ore a
    }

    public void problem6() {
        int count;
        String s = "Surface tension";
        count = s.length(); // 15
    }

    public void problem7() {
        String m = "Look here!";
        System.out.println("\"" + m + "\" has " +  m.length() + " characters.");
    }

    public void problem8() {
        System.out.println("All \"good\" men should come to the aid of their country.");
    }

    public void problem9() {
        System.out.println("Hello\nHello again");
    }

    public void problem10() {
        System.out.println("A backslash looks like this \\, ...right?");
    }

}

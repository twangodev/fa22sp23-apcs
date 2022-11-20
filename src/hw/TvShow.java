package hw;

@SuppressWarnings("AccessStaticViaInstance")
public class TvShow {

    public String actor1 = "Don Knots";
    public static String actor2 = "Homer Simpson";
    public static int numShows = 0;
    public static int x = 59;
    public int y = 1059;
    public String showName;

    public TvShow(String nm) {
        numShows++;
        showName = nm;
    }

    public static int numberOfShows() {
        return numShows;
    }

    public void setActor1(String act1) {
        actor1 = act1;
    }

    public static void main(String[] args) {
        // 1. At any time after several TvShow objects have been instantiated, how would you find out how many shows were instantiated? (Don't use an object to do this.)
        System.out.println("There are " + TvShow.numberOfShows() + " shows.");
        // 2. Would the code inside the numberOfShows() method work if the numShows variable were not static? If not, why?
        // Yes, because it is referencing a static variable numShows. However, this would only work if the method was referenced by an objecct
        // 3. Suppose the code inside the numberOfShows method is replaced with the following line: return y; Is this legal? If not, why?
        // Yes. Because y is not static, it must either be initialized initially or by a constructor. In this case, it is already initialized.
        // 4. Write code that will print the data member actor2. Do this without instantiating any objects
        System.out.println(TvShow.actor2);
        // 5. Is the following code legal? If not, why? TvShow.setActor1("Jimmy Stewart");
        // No, because setActor1 is not static. It must be referenced by an object.
        // 6. Create an instance TvShow called chrs (pass in the String "Cheers") and use it to access and print the class variable numShows.
        TvShow chrs = new TvShow("Cheers");
        System.out.println(chrs.numShows);
        // 7. Give the output of the following:
        System.out.println(TvShow.x); // 59

        System.out.println(TvShow.x); // 59
        System.out.println(chrs.x); // 59

        TvShow hc = new TvShow("History Channel");
        hc.x = 160;
        System.out.println(TvShow.x); // 160
        System.out.println(chrs.x); // 160
    }

}

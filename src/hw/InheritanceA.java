package hw;

public class InheritanceA {

    public class Red extends Green {
        public int blue(double x) {return 0;}
        public String s;
        private int i;
    }

    public class Green {
        public double peabody(double y) {return mm;}
        private boolean crunch( ) { return true; }
        private double mm;
        public long xx;
    }

    // 1. Which of the above classes is the base class?
    // Green

    // 2. Which of the two above classes is the subclass?
    // Red

    // 3. Which of the above classes is the superclass?
    // Green

    // 4. Which of the above classes is the derived class?
    // Red

    // 5. Is this legal? If not, why not? (Assume this code in some class other than the two above)
    public void problem5() {
        Red myObj = new Red();
        // boolean bb = myObj.crunch();
    }
    // No, crunch is private.

    // 6. Is this legal? If not, why not? (Assume this code in some class other than the two above)
    public void problem6() {
        Red myObj = new Red();
        int bb = myObj.blue(105.2);
    }
    // Yes, blue is available to the Red class.

    // 7. Write code for the blue method that will print out the mm state variable.
    // public int blue(double x) {return peabody(x);}

    // 8. Write code for the blue method that will print out the xx state variable.
    // public int blue(double x) {return (int) xx;}

    /**
     * public class Red extends Green
     * {
     *  public int blue(double x)
     *  { . . . }
     *  public double peabody(double vv)
     *  {
     *  }
     *  public String s;
     * private int i;
     * }
     * public class Green
     * {
     *  public Green(long j)
     *  {
     *  xx = j;
     *  }
     *  public double peabody(double y)
     *  {
     *  return mm;
     *  }
     *  private Boolean crunch( )
     *  { . . . }
     *  private double mm;
     *  public long xx;
     * }
     */

    // 9. Consider the following constructor in Red class:
    // Public Red() { What code would you put here to invoke the constructor of the superclass and send it as a
    // parameter value of 32000? }
    // super(32000);

    // 10. Is there any method in Red that is override a method in Green? If so, what is it?
    // Yes, peabody.

    // 11. Look at the peabody method inside Red. Write the code inside the method that will allow you to access the
    // same method inside its superclass, Green. Let the parameter have a value of 11.
    // public double peabody(double vv) {return super.peabody(11);}

    // 12. Consider the following constructor in Red class:
    // Public Red() { String s = "Hello"; super(49); }
    // Is this code legal? If not, why not?
    // Yes, it is legal.

}

package hw;

public class InheritanceB {

    public abstract class Hammer {
        public abstract void duty( );
        public abstract int rule(int d);
    }

    public class Lurch extends Hammer {
        public void duty() {int x = Y;}
        public int rule(int d) {
            Y = d + 1;
            return Y;
        }
        private int Y = 30;
        private int x;
    }

    // 1. What is the purpose of making the two methods above abstract?
    // To force the subclass to implement them.

    // 2. Write out the full signature of the rule method.
    // public int rule(int d)

    // 3. Which class actually implements the duty method?
    // Lurch

    // 4. A class for which you cannot create objects is called a(n) ________ class.
    // Abstract class

    // 5. public abstract class Felix { ... }
    // Is the following attempt an object from the Felix class legal? If not, why not?
    // No, Felix is an abstract class.

    // 6. Is the following legal? If not, why?
    // public abstract class Lupe {
    //     public abstract void fierce() { ... }
    //     public final double PI = 3.14;
    // }
    // No, abstract methods cannot have a body.

    // 7. What is the main reason for using abstract classes?
    // To force subclasses to implement certain methods.

}

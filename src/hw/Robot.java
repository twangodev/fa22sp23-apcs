package hw;

import java.util.Arrays;

public class Robot {

    private final int[] hall;
    private int pos; // current position(tile number) of Robot
    private boolean facingRight; // true means this Robot is facing right

    /**
     * constructor: len is the length of the hall;
     * pre: len is greater than 0
     * post: random numbers (<5) in the hall, pos at 0, facingRight=true
     */
    public Robot (int len) {
        hall = new int[len];
        for (int i = 0; i < hall.length; i++) {
            hall[i] = (int) (Math.random() * 5);
        }
        pos = 0;
        facingRight = true;
    }


    // postcondition: returns true if this Robot has a wall immediately in
    // front of it, so that it cannot move forward;
    // otherwise, returns false
    private boolean forwardMoveBlocked() {
        if (facingRight) {
            return pos == hall.length - 1;
        } else {
            return pos == 0;
        }
    }

    // postcondition: one move has been made according to the
    // specifications above and the state of this
    // Robot has been updated
    private void move() {
        if (hall[pos] > 0) {
            hall[pos]--;
        }

        if (hall[pos] == 0) {
            if (forwardMoveBlocked()) {facingRight = !facingRight;}
            if (facingRight) {pos++;} else {pos--;}
        }

    }

    // postcondition: no more items remain in the hallway;
    // returns the number of moves made
    public int clearHall() {
        int moves = 0;
        while (!hallIsClear()) {
            move();
            System.out.println(this);
            moves++;
        }
        return moves;
    }

    // postcondition: returns true if the hallway contains no items;
    // otherwise, returns false
    private boolean hallIsClear() {
        for (int i : hall) {
            if (i > 0) return false;
        }
        return true;
    }

    /**
     * toString to show the hall
     * */
    public String toString() {
        StringBuilder rob = new StringBuilder(" <");
        if (facingRight) rob = new StringBuilder(" >");
        for (int i = 0; i < pos; i++) rob.insert(0, "   ");
        return Arrays.toString(hall) + "\n" + rob;

    }
    public static void main (String[] args) {
        Robot myDog = new Robot(5);
        System.out.println(myDog);
    }

}

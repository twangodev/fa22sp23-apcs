package hw.fractal;

import java.awt.*;

/******************************************************************************
 *  Turtle graphics (awt.Graphics) Mr.Shen, APCS 2023
 ******************************************************************************/
public class Turtle {
    Graphics g;
    private double x, y;     // turtle is at (x, y)
    private double angle;    // facing this many degrees counterclockwise from the x-axis

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(Graphics g, int x0, int y0, int a0) {
        this.g = g;
        x = x0;
        y = y0;
        angle = a0;
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(int delta) {
        angle -= delta;
    }

    // move forward the given amount, with the pen down
    public void forward(int step) {
        int oldx = (int) Math.round(x);
        int oldy = (int) Math.round(y);
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        g.drawLine(oldx, oldy, (int) Math.round(x), (int) Math.round(y));
    }

}
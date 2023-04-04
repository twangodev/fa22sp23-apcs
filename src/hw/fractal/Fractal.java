package hw.fractal;

import javax.swing.*;
import java.awt.*;

public class Fractal extends JPanel {

    Turtle turtle;

    public void paintComponent(Graphics g) {
        turtle = new Turtle(g, 10, 300, 0);
        drawFractal(4, 100);
    }

    private void drawTriangle(int size) {
        turtle.forward(size);
        turtle.turnLeft(60);
        turtle.forward(size);
        turtle.turnLeft(-120);
        turtle.forward(size);
        turtle.turnLeft(60);
        turtle.forward(size);
    }

    public void drawFractal (int level, int size) {
        if (level == 0) drawTriangle(size);
        else {
            drawFractal(level - 1, size / 2);
            turtle.turnLeft(60);
            drawFractal(level - 1, size / 2);
            turtle.turnLeft(-120);
            drawFractal(level - 1, size / 2);
            turtle.turnLeft(60);
            drawFractal(level - 1, size / 2);
        }
    }

    public static void main (String[] args) {
        JFrame window = new JFrame("Fractal 3");
        window.setBounds(100, 100, 720, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Fractal mcObj = new Fractal();
        window.getContentPane().add(mcObj);
        window.setVisible(true);
    }

}
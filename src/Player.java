package src;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel {
    private int x = 400;
    private int y = 400;

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            g2d.drawImage(ImageIO.read(new File("resources\\player.png")), x, y, 160, 200, null);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void reset() {
        x = 400;
        y = 400;
    }

    public void moveNorth() {
        y -= 60;
        if (y <= 140) {
            y = 140;
        }
        repaint();
    }

    public void moveEast() {
        x += 60;

        if (x >= Constants.SW - 180) {
            x = Constants.SW - 180;
        }

        repaint();

    }

    public void moveSouth() {
        y += 60;

        if (y >= Constants.SH - 220) {
            y = Constants.SH - 220;
        }

        repaint();

    }

    public void moveWest() {

        x -= 60;
        if (x <= 60) {
            x = 60;
        }

        repaint();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

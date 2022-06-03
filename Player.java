import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel {
    private int x = 200;
    private int y = 200;

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            g2d.drawImage(ImageIO.read(new File("resources\\player.png")), x, y, 80, 100, null);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void reset() {
        x = 200;
        y = 200;
    }

    public void moveNorth() {
        y -= 30;
        if (y <= 70) {
            y = 70;
        }
        repaint();
    }

    public void moveEast() {
        x += 30;

        if (x >= Constants.SW - 90) {
            x = Constants.SW - 90;
        }

        repaint();

    }

    public void moveSouth() {
        y += 30;

        if (y >= Constants.SH - 110) {
            y = Constants.SH - 110;
        }

        repaint();

    }

    public void moveWest() {

        x -= 30;
        if (x <= 30) {
            x = 30;
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

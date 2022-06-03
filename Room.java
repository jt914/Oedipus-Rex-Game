import javax.imageio.ImageIO;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import java.io.File;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;
import java.io.BufferedInputStream;
import java.io.File;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Room extends JPanel implements ActionListener {
    private int id;
    private boolean northWall, eastWall, southWall, westWall;
    private static int roomCounter;
    private Timer timer;
    private JLabel roomId;
    private boolean atDoor;
    String northText, eastText, southText, westText;

    public Room(boolean northWall, boolean eastWall, boolean southWall, boolean westWall, String northText,
            String eastText, String southText, String westText) {
        setLayout(new BorderLayout());

        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
        id = roomCounter;
        roomCounter++;
        this.northText = northText;
        this.eastText = eastText;
        this.southText = southText;
        this.westText = westText;
        // timer = new Timer(1, this);

        JPanel NORTH = new JPanel(new FlowLayout(FlowLayout.LEFT));
        roomId = new JLabel(Constants.currentDisplayRow + ", " + Constants.currentDisplayColumn, SwingConstants.LEFT);
        roomId.setHorizontalAlignment(SwingConstants.LEFT);
        NORTH.add(roomId);
        this.add(NORTH, BorderLayout.NORTH);

    }

    public void actionPerformed(ActionEvent e) {
        // if (Constants.currentRoomId == id) {
        // JLabel label = new JLabel("My label");
        // label.setText("<html>This is a<br>multline label!<br> Try it
        // yourself!</html>");

        // this.add(label);
        // System.out.println(Constants.player.getX() + ", " + Constants.player.getY());

        // MOVE NORTH
        if (Constants.player.getX() > 160 && Constants.player.getY() > 0 && Constants.player.getX() < 260
                && Constants.player.getY() < 50) {

            int result = JOptionPane.showConfirmDialog(this, northText);
            if (result != 1) {

                Constants.timer.restart();
                atDoor = true;

            } else {

            }

            // MOVE EAST
        } else if (Constants.player.getX() > 380 && Constants.player.getY() > 180 && Constants.player.getX() < 480
                && Constants.player.getY() < 270 && atDoor == false) {
            int result = JOptionPane.showConfirmDialog(this, eastText);
            if (result != 1) {

                Constants.timer.restart();
                atDoor = true;

            }

            // MOVE SOUTH
        } else if (Constants.player.getX() > 180 && Constants.player.getY() > 380 && Constants.player.getX() < 280
                && Constants.player.getY() < 480) {
            int result = JOptionPane.showConfirmDialog(this, southText);

            if (result != 1) {

                Constants.timer.restart();
                atDoor = true;

            }
        }

        // MOVE WEST
        else if (Constants.player.getX() > 0 && Constants.player.getY() > 200 && Constants.player.getX() < 50
                && Constants.player.getY() < 280)

        {

            int result = JOptionPane.showConfirmDialog(this, westText);
            if (result != 1) {

                Constants.timer.restart();
                atDoor = true;

            }

        }

        else {
            atDoor = false;
        }

        // JDialog jd = new JDialog();
        // jd.setLayout(new FlowLayout());
        // jd.setBounds(0, 0, 50, 50);
        // JLabel label = new JLabel("test");
        // JButton button = new JButton("click");
        // button.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // System.out.println("worked");
        // }
        // });

        repaint();

    }

    // }

    public BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height) {
        BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
        return croppedImage;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        try {

            g2d.drawImage(ImageIO.read(new File("resources\\grassBG.png")), 0, 0,
                    Constants.SW, Constants.SH, null);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        if (northWall) {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\northWall.png")), 0, 20, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\northWall.png")), 0, 0, 201, 30), 0, 20,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\northWall.png")), 0, 0, 200, 30), 298, 20,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                g2d.drawImage(ImageIO.read(new File("resources\\northDoor.png")), 199, 20, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (southWall) {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\southWall.png")), 0, 440, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\southWall.png")), 0, 0, 201, 30), 0, 440,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\southWall.png")), 0, 0, 200, 30), 298, 440,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                g2d.drawImage(ImageIO.read(new File("resources\\southDoor.png")), 199, 440, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (eastWall) {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\eastWall.png")), 460, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\eastWall.png")), 0, 0, 30, 201), 460, 0,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\eastWall.png")), 0, 0, 30, 200), 460, 298,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                g2d.drawImage(ImageIO.read(new File("resources\\eastDoor.png")), 460, 199, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (westWall) {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\westWall.png")), 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\westWall.png")), 0, 0, 30, 201), 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\westWall.png")), 0, 0, 30, 200), 0, 298,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                g2d.drawImage(ImageIO.read(new File("resources\\westDoor.png")), 0, 199, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Constants.player.draw(g2d);

    }

}

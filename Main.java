import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.management.InvalidAttributeValueException;
import javax.swing.*;

public class Main {

    public static boolean playGame(String text) {
        Constants.labyrinth = new Labyrinth();
        System.out.println("working");
        // Constants.labyrinth.printMap();
        return false;
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // System.out.println("Would you like to play a game? (Yes/No)");
        // boolean alive = true;
        // String play = in.nextLine();
        // if (play.equalsIgnoreCase("Yes") || play.equalsIgnoreCase("Y")) {
        // while (alive) {
        // System.out.println(
        // "Welcome to the game.\nType help for commands, and exit to leave the game.
        // Use single word commands.\n-------------------------------------\n FILLER
        // TEXT. PUT STARTING STUFF HERE");
        // alive = playGame(in.nextLine());
        // }
        // }

        // basically all the images to draw on the screen
        // Constants.SW = ImageIO.read(new File(Constants.paths.get(3))).getWidth();
        // Constants.SH = ImageIO.read(new File(Constants.paths.get(3))).getHeight();

        // Creates new frame, or window
        JFrame frame = new JFrame();

        // once you hit the little x button its gonna stop the code
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sets the screen size to the specified lengths in constants
        frame.setSize(Constants.SW, Constants.SH);
        // for (int i = 0; i < 4; i++) {
        // for (int j = 0; j < 4; j++) {
        // Constants.rooms[i][j] = new Room(true, true, true, true);
        // }
        // }

        // main window is basically a panel, or part of the frame
        Room room = new Room(true, false, true, true);
        IDLabel topLabel = new IDLabel();
        Constants.rooms[3][0] = room;
        // setting the locaiton and adding it onto the frame
        room.setLocation(100, 100);
        frame.add(room);
        // frame.add(topLabel);
        // topLabel.setMinWidth(50);
        // topLabel.setMinHeight(50);

        playGame("");

        // makes it visible
        KeyListener listener = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case (KeyEvent.VK_W): {
                        room.repaint();
                        Constants.player.moveNorth();
                        break;
                    }
                    case (KeyEvent.VK_A): {
                        room.repaint();
                        Constants.player.moveWest();
                        break;
                    }
                    case (KeyEvent.VK_S): {
                        room.repaint();

                        Constants.player.moveSouth();

                        break;

                    }
                    case (KeyEvent.VK_D): {
                        room.repaint();

                        Constants.player.moveEast();

                        break;
                    }

                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        };
        frame.setVisible(true);
        frame.addKeyListener(listener);
    }

}

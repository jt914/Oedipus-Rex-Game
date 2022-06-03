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
        // System.out.println("working");
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
        Constants.frame = new JFrame();

        // once you hit the little x button its gonna stop the code
        Constants.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sets the screen size to the specified lengths in constants
        Constants.frame.setSize(Constants.SW, Constants.SH);
        // for (int i = 0; i < 4; i++) {
        // for (int j = 0; j < 4; j++) {
        // Constants.rooms[i][j] = new Room(true, true, true, true);
        // }
        // }

        // main window is basically a panel, or part of the frame

        Room room = new Room(false, false, true, true,
                "You promise to save the people. The murderer shall pay! Do you wish to fulfill this duty?",
                "This is the bathroom. Continue?",
                null, null,
                "In order to rid the city of the curse, you must expel the murderer of\n King Laius from Thebes.", 12);
        Room room1 = new Room(false, false, false, true,
                "No matter how much better you feel, ignorance will only keep you from the desired truth",
                "Behind this door will be your faith or truth, continue?",
                "This will lead you to your previous room. Go through?", null,
                "Teiresias prophesizes that you are the killer. What do you wish to do?", 8);
        Room room2 = new Room(false, false, false, false,
                "Why must you stay so blind? Though behind this door may be some treasure. Continue?",
                "You must be concious and aware. Do you wish to continue?",
                "This is the bathroom. Continue?", "This will lead you to your previous room. Go through?",
                "You recall the day when you killed several men on a wagon, where three roads met. THe drunken man from the banquet told you that you were adopted.",
                9);
        Room room3 = new Room(false, false, false, false,
                "Do you decide to talk to the stranger? You are very close to the truth, continue if you wish. Good luck.",
                "Are you too scared to confront the truth? Enter if so.",
                "This is the dining room. Continue?", "This will lead you to your previous room. Go through?",
                "Someone suggests that you meet with the lone survivor of the event, one of the servants of Laius, who was there when Laius was murdered.",
                10);
        Room room4 = new Room(false, false, false, false,
                "Do you wish to say that he is a liar and have him executed?",
                "Do you accept the truth and stab your eyes out?",
                "This will lead you to your previous room. Go through?",
                "Though behind this door may be some goodies. Continue?",
                "The servant reveals the story of the prophecy, and how you, King Laius, and Jocasta were  related through blood.",
                6);

        Room room5 = new Room(false, true, false, false,
                "You will be exiled from the city to rid of all of your sins and the suffering that you have brought among your people. Continue?",
                null,
                "If you go through this room, you will self harm to the extent of death.",
                "This will lead you to your previous room. Go through?",
                "As earlier promised, Creon decides that he will listen to the god as to what should happen to you.",
                7);
        Room room6 = new Room(false, true, false, false,
                "You will be exiled from the city to rid of all of your sins and the suffering that you have brought among your people. Continue?",
                null,
                null,
                "This is the bedroom where Jocasta hung herself. Continue?",
                "You end up getting exiled out of Thebes, and your life is ruined.",
                3);
        Room room7 = new Room(false, true, false, false,
                "You will be exiled from the city to rid of all of your sins and the suffering that you have brought among your people. Continue?",
                null,
                null,
                "This is the bedroom where Jocasta hung herself. Continue?",
                "You end up getting exiled out of Thebes, and your life is ruined. What a Bozo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",
                3);

        Constants.rooms[3][0] = room;
        Constants.rooms[2][0] = room1;
        Constants.rooms[2][1] = room2;
        Constants.rooms[2][2] = room3;
        Constants.rooms[1][2] = room4;
        Constants.rooms[1][3] = room5;
        Constants.rooms[0][3] = room6;

        // setting the locaiton and adding it onto the frame
        Constants.frame.add(room);
        // frame.add(topLabel);
        // topLabel.setMinWidth(50);
        // topLabel.setMinHeight(50);

        playGame("");

        // makes it visible
        KeyListener listener = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case (KeyEvent.VK_W): {
                        Constants.player.moveNorth();
                        Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId % 4].repaint();

                        break;
                    }
                    case (KeyEvent.VK_A): {
                        Constants.player.moveWest();
                        Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId % 4].repaint();

                        break;
                    }
                    case (KeyEvent.VK_S): {

                        Constants.player.moveSouth();
                        Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId % 4].repaint();

                        break;

                    }
                    case (KeyEvent.VK_D): {

                        Constants.player.moveEast();
                        Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId % 4].repaint();

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
        Constants.frame.setVisible(true);
        Constants.frame.addKeyListener(listener);
    }

}

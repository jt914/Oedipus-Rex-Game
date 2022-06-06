package src;

import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.plaf.TreeUI;

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
                Constants.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                Constants.frame.setUndecorated(true);

                // sets the screen size to the specified lengths in constants
                Constants.frame.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()),
                                (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth());
                // for (int i = 0; i < 4; i++) {
                // for (int j = 0; j < 4; j++) {
                // Constants.rooms[i][j] = new Room(true, true, true, true);
                // }
                // }

                // main window is basically a panel, or part of the frame

                Room room = new Room(false, false, true, true,
                                "Do you wish to pledge to save your people and find the truth? Continue if so.",
                                "Do you want to delay the inevitable and remain inside your castle, desperately hoping for a solution to all your problems?",
                                null, null,
                                "You are the King of Thebes. There is a plague <br> afflicting your city and an unsolved murder. <br>What do you wish to do? Choose your path wisely, as <br>each step may bring your further or closer to the truth.",
                                12);
                Room room1 = new Room(false, false, false, true,
                                "No matter how much better you feel, ignorance will only keep you from understanding your destiny. Continue if you want to venture into a life of falsehood.",
                                "Even though you are infuriated with the Tiresias and Creon for the accusation, do you wish to continue with the quest for the good of the people?",
                                "Do you wish the return to the starting room?", null,
                                "In your quest for truth, you visit Teiresias, a blind<br>prophet. Teiresias tells you that you are the killer. <br> What do you wish to do?",
                                8);
                Room room2 = new Room(true, false, true, false,
                                null,
                                "Do you wish to continue on? You are very near the truth, yet nothing is understood yet.",
                                null,
                                "This will lead you to your previous room. Go through?",
                                "You confront Jocasta with the information you have <br>gathered. You recall the day when you killed <br>several men at a crossroads, and when a drunken<br> man told you that you were adopted. Jocasta <br>explains the prophecy of her son murdering <br>the old king.",
                                9);
                Room room3 = new Room(false, false, false, false,
                                "Jocasta has fled, screaming, leaving you confused. Do you wish to continue and find? You are tantalizingly close to the truth about your life.",
                                "You sense something is not right. Do you wish to leave the messenger and do further investigation?",
                                "Do you wish to run away from your troubles and attempt to flee the city?",
                                "This will lead you to your previous room. Go through?",
                                "A messenger comes to you with news about the old <br> king's death. After further interrogation, you discover<br> from the messenger that you were adopted. <br>Then he tells you that Laius, the old king, and<brJocasta had a child in the past, yet the baby <br>was given to a shepherd to abandon.",
                                10);
                Room room4 = new Room(false, false, false, true,
                                "Do you wish to say that he is a liar and have him executed?",
                                "Do you accept the truth and stab your eyes out?",
                                "This will lead you to your previous room. Go through?",
                                null,
                                "The shepherd reveals to you the remainder of <br>the story. You piece together the horrible truth.",
                                6);

                Room room5 = new Room(false, true, true, false,
                                "Do you wish to accept your punishment for the good of the people?",
                                null,
                                null,
                                "This will lead you to your previous room. Go through?",
                                "As earlier promised, Creon decides that he will <br>listen to the gods as to what should happen<br> to you. You will be exiled from the <br>city to rid of all of your sins and the suffering<br> that you have brought among your people.",
                                7);
                Room room6 = new Room(false, true, true, true,
                                null,
                                null,
                                "Do you wish to return to the previous room?",
                                null,
                                "You are exiled out of Thebes, and your life is <br>ruined. Continue North.",
                                3);

                // trash rooms
                Room room7 = new Room(true, true, false, true,
                                null,
                                null,
                                "Do you wish to return to your quest for the truth?",
                                null,
                                "The gods have become fed up with your inability to<br> listen, and have decided to punish your wife. <br>Jocasta is now infected with the disease that has <br>been spreading around the city.",
                                4);
                Room room8 = new Room(true, true, false, false,
                                null,
                                null,
                                "You will enter a trash room. Continue",
                                "You will enter a trash room. Continue?",
                                "This is a trash room",
                                0);
                Room room9 = new Room(true, false, false, false,
                                null,
                                "You will enter a trash room. Continue",
                                "You will enter a trash room. Continue",
                                "You will enter a trash room. Continue",
                                "This is a trash room",
                                1);
                Room room10 = new Room(false, false, false, false,
                                "You will enter a trash room. Continue",
                                "You have wandered back toward the truth. Do you decide to talk to the stranger? Continue if you wish. Good luck.",
                                "Behind this door will be your faith or truth, continue?",
                                "You will enter a trash room. Continue",
                                "This is a trash room",
                                5);
                Room room11 = new Room(true, true, true, false,
                                null,
                                null,
                                null,
                                "Do you wish to return to the starting room for a chance to fix everything?",
                                "You have neglected the truth, and the gods have <br>begun punishing you and your people. Many of your<br> citizens are dead, and many more are furious<br> at your seemingly apathetic behaviour.",
                                13);
                Room room12 = new Room(true, true, false, true,
                                null,
                                null,
                                "Do you wish to return to the previous room?",
                                null,
                                "Despite your best efforts and yelling, you <br>have lost your authority and respect. It <br>seems the gods have also thrown great <br>disrespect upon your name.",
                                2);
                Room room13 = new Room(false, false, true, false,
                                "You must be concious and aware, as you have come back near the truth. Do you wish to continue?",
                                "You will enter a trash room. Continue",
                                null,
                                "You will enter a trash room. Continue",
                                "This is a trash room",
                                14);
                Room room14 = new Room(true, true, true, false,
                                "You have come very near the truth. Do you accept it and stab your eyes out?",
                                "You must be concious and aware, as you have wandered near the truth. Do you wish to continue?",
                                "You will enter a trash room. Continue",
                                "Do you wish to return to to the path of truth?",
                                "Despite your best efforts to flee, the gods <br>have chosen your destiny, and you <br>are unable to leave.",
                                11);
                Room room15 = new Room(false, true, true, false,
                                "You will enter a trash room. Continue",
                                null,
                                null,
                                "You will enter a trash room. Continue",
                                "This is a trash room",
                                15);
                Constants.rooms[3][0] = room;
                Constants.rooms[2][0] = room1;
                Constants.rooms[2][1] = room2;
                Constants.rooms[2][2] = room3;
                Constants.rooms[1][2] = room4;
                Constants.rooms[1][3] = room5;
                Constants.rooms[0][3] = room6;
                Constants.rooms[1][0] = room7;
                Constants.rooms[0][0] = room8;
                Constants.rooms[0][1] = room9;
                Constants.rooms[1][1] = room10;
                Constants.rooms[3][1] = room11;
                Constants.rooms[0][2] = room12;
                Constants.rooms[3][2] = room13;
                Constants.rooms[2][3] = room14;
                Constants.rooms[3][3] = room15;

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
                                                Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId
                                                                % 4].repaint();

                                                break;
                                        }
                                        case (KeyEvent.VK_A): {
                                                Constants.player.moveWest();
                                                Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId
                                                                % 4].repaint();

                                                break;
                                        }
                                        case (KeyEvent.VK_S): {

                                                Constants.player.moveSouth();
                                                Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId
                                                                % 4].repaint();

                                                break;

                                        }
                                        case (KeyEvent.VK_D): {

                                                Constants.player.moveEast();
                                                Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId
                                                                % 4].repaint();

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

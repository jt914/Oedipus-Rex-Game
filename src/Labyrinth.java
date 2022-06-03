package src;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
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
import javax.swing.*;

public class Labyrinth implements ActionListener {
    // private Room[][] rooms = new Room[4][4];
    private int currentPos;

    public Labyrinth() {
        // System.out.println("wasd");
        Constants.timer = new Timer(100, this);
        Constants.timer.start();

    }

    public boolean moveNorth() {
        currentPos -= 3;
        return false;
    }

    public boolean moveEast() {
        currentPos += 1;
        return false;
    }

    public boolean moveSouth() {
        currentPos += 3;
        return false;
    }

    public boolean moveWest() {
        currentPos -= 1;
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println((Constants.currentRoomId / 4));
        // System.out.println((Constants.currentRoomId % 4));
        Constants.frame.remove(Constants.rooms[Constants.oldId / 4][Constants.oldId % 4]);
        Constants.frame.add(Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId % 4]);
        Constants.frame.validate();

        Constants.rooms[Constants.currentRoomId / 4][Constants.currentRoomId % 4].repaint();

        Constants.rooms[(Constants.currentRoomId / 4)][(Constants.currentRoomId % 4)]
                .actionPerformed(new ActionEvent(e, currentPos, null));

    }
}
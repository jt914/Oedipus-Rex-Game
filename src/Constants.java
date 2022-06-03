package src;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Constants {
    public static Labyrinth labyrinth;
    public final static int SW = 1000;
    public final static int SH = 1020;
    public final static Player player = new Player();
    public static int currentRoomId = 12;
    public static int oldId = 12;
    public static Room[][] rooms = new Room[4][4];
    public static Timer timer;
    public static int currentDisplayRow = 0;
    public static int currentDisplayColumn = 0;
    public static JFrame frame;

}

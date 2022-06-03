import java.awt.*;

import javax.swing.Timer;

public class Constants {
    public static Labyrinth labyrinth;
    public final static int SW = 500;
    public final static int SH = 500;
    public final static Player player = new Player();
    public static int currentRoomId = 13;
    public static Room[][] rooms = new Room[4][4];
    public static Timer timer;
    public static int currentDisplayRow;
    public static int currentDisplayColumn;

}

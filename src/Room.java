package src;

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

//todo make the reset smoother by makng it reset to where it would actually end up

public class Room extends JPanel implements ActionListener {
    private int id;
    private boolean northWall, eastWall, southWall, westWall;
    private JLabel topWords;
    private boolean atDoor;
    String northText, eastText, southText, westText, topDesc;
    private JPanel NORTH;

    public Room(boolean northWall, boolean eastWall, boolean southWall, boolean westWall, String northText,
            String eastText, String southText, String westText, String topDesc, int id) {
        setLayout(new BorderLayout());

        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
        this.id = id;
        this.northText = northText;
        this.eastText = eastText;
        this.southText = southText;
        this.westText = westText;
        this.topDesc = topDesc;
        // timer = new Timer(1, this);

        NORTH = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // roomId = new JLabel(Constants.currentDisplayRow + ", " +
        // Constants.currentDisplayColumn, SwingConstants.LEFT);
        // roomId.setHorizontalAlignment(SwingConstants.LEFT);

        topWords = new JLabel(topDesc, SwingConstants.RIGHT);
        topWords.setText("<html><h2>" + topDesc
                + "</h2><br><br><br><br><h2>Current Position in Dungeon<h1>" + Constants.currentDisplayRow + ", "
                + Constants.currentDisplayColumn
                + "</h1></html>");

        // topWords.setText(topDesc);
        // NORTH.add(roomId);
        NORTH.add(topWords);
        Font font = new Font("Verdana", Font.BOLD, 20);
        NORTH.setFont(font);
        NORTH.setPreferredSize(new Dimension(500, 1000));
        this.add(NORTH, "East");
        // BufferedImage image = null;
        // try {
        // image = ImageIO.read(new File("resources\\grid.png"));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // JLabel picLabel = new JLabel(new ImageIcon(image));
        // NORTH.add(picLabel, JFrame.BOTTOM_ALIGNMENT);

    }

    public void actionPerformed(ActionEvent e) {
        // System.out.println(Constants.currentDisplayRow + ", " +
        // Constants.currentDisplayColumn);

        // System.out.println(id);
        // System.out.println(Constants.currentRoomId);
        Constants.oldId = this.id;
        // System.out.println(Constants.player.getX() + ", " + Constants.player.getY());

        if (Constants.currentRoomId == id) {
            // System.out.println(Constants.player.getX() + ", " + Constants.player.getY());
            // JLabel label = new JLabel("My label");
            // label.setText("<html>This is a<br>multline label!<br> Try it
            // yourself!</html>");

            // this.add(label);
            // System.out.println(Constants.player.getX() + ", " + Constants.player.getY());

            // MOVE NORTH
            if (Constants.player.getX() >= 340 && Constants.player.getY() >= 0
                    && Constants.player.getX() <= 520
                    && Constants.player.getY() <= 110) {
                // System.out.println("working");

                if (!northWall && !atDoor) {
                    if (Constants.currentRoomId == 3) {
                        int finished = JOptionPane.showConfirmDialog(this,
                                "You have finished the storyline and your journey.", "finished",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (finished == JOptionPane.OK_OPTION) {
                            System.exit(1);
                        }
                    }

                    int result = JOptionPane.showConfirmDialog(this, northText, "northOption",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        // System.out.println("wasd");
                        Constants.currentRoomId -= 4;
                        Constants.currentDisplayRow += 1;
                        Constants.player.reset();

                    } else if (result == JOptionPane.NO_OPTION) {
                        // Constants.timer.restart();
                        atDoor = true;
                    } else {
                        System.out.println("None Selected");
                    }
                }
                return;

                // MOVE EAST
            } else if (Constants.player.getX() >= 730 && Constants.player.getY() >= 280
                    && Constants.player.getX() <= 800
                    && Constants.player.getY() <= 460) {
                if (!eastWall && !atDoor) {
                    int result = JOptionPane.showConfirmDialog(this, eastText, "eastOption",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        Constants.currentRoomId += 1;
                        Constants.currentDisplayColumn += 1;
                        Constants.player.reset();

                    } else if (result == JOptionPane.NO_OPTION) {
                        // Constants.timer.restart();
                        atDoor = true;
                    } else {
                        System.out.println("None Selected");
                    }
                }
                return;

                // MOVE SOUTH
            } else if (Constants.player.getX() >= 340 && Constants.player.getY() >= 690
                    && Constants.player.getX() <= 700
                    && Constants.player.getY() <= 810) {
                if (!southWall && !atDoor) {
                    int result = JOptionPane.showConfirmDialog(this, southText, "southOption",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (result == JOptionPane.YES_OPTION) {
                        // System.out.println("wasd");
                        Constants.currentRoomId += 4;
                        Constants.currentDisplayRow -= 1;
                        Constants.player.reset();

                    } else if (result == JOptionPane.NO_OPTION) {
                        // Constants.timer.restart();
                        atDoor = true;
                    } else {
                        System.out.println("None Selected");
                    }
                }
                return;
            }

            // MOVE WEST
            else if (Constants.player.getX() > 0 && Constants.player.getY() >= 280
                    && Constants.player.getX() <= 120
                    && Constants.player.getY() <= 460) {
                if (!westWall && !atDoor) {
                    int result = JOptionPane.showConfirmDialog(this, westText, "westOption",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        Constants.currentRoomId -= 1;
                        Constants.currentDisplayColumn -= 1;
                        Constants.player.reset();

                    } else if (result == JOptionPane.NO_OPTION) {
                        atDoor = true;
                    } else {
                        System.out.println("None Selected");
                    }
                }
                return;
            }
            atDoor = false;

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

    }

    // }

    public BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height) {
        BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
        return croppedImage;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // roomId.setText(Constants.currentDisplayRow + ", " +
        // Constants.currentDisplayColumn);
        topWords.setText("<html><h2>" + topDesc
                + "</h2><br><br><br><br><h2>Current Position in Dungeon<h1>" + Constants.currentDisplayRow + ", "
                + Constants.currentDisplayColumn
                + "</h1></html>");
        try {

            g2d.drawImage(ImageIO.read(new File("resources\\grassBG.png")), 0, 0,
                    Constants.SW, Constants.SH, null);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        if (northWall) {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\northWall.png")), 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\northDoor.png")), 404, 30, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\northWall.png")), 0, 0, 415, 60), 0, 0,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\northWall.png")), 0, 0, 400, 60), 601, 0,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (southWall) {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\southWall.png")), 0, 950, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            try {
                g2d.drawImage(ImageIO.read(new File("resources\\southDoor.png")), 398, 940, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\southWall.png")), 0, 0, 415, 60), 0, 950,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\southWall.png")), 0, 0, 400, 60), 596, 950,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (eastWall) {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\eastWall.png")), 960, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                g2d.drawImage(ImageIO.read(new File("resources\\eastDoor.png")), 950, 398, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\eastWall.png")), 0, 0, 60, 412), 940, 0,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\eastWall.png")), 0, 0, 60, 410), 940, 596,
                        null);
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
                g2d.drawImage(ImageIO.read(new File("resources\\westDoor.png")), 30, 398, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\westWall.png")), 0, 0, 60, 402), 0, 0,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                g2d.drawImage(cropImage(ImageIO.read(new File("resources\\westWall.png")), 0, 0, 60, 400), 0, 596,
                        null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Constants.player.draw(g2d);

    }

}

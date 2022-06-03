import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class IDLabel extends JPanel {
    public IDLabel() {
        JLabel label = new JLabel("My label");
        label.setText("<html>This is a<br>multline label!<br> Try it yourself!</html>");
        label.setPreferredSize(new Dimension(460, 30));

    }

}

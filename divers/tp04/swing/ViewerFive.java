package tp04.swing;

import javax.swing.*;
import java.awt.*;

public class ViewerFive extends JFrame {
    JButton searchButton_;
    JButton exitButton_;

    public ViewerFive() {
        super("Database Viewer Five");
        searchButton_ = new JButton("Search");
        exitButton_ = new JButton("Exit");
        setLayout(new FlowLayout());
        add(searchButton_);
        add(exitButton_);
        pack();
        setVisible(true);
    }

}

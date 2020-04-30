package tp04.swing;

import javax.swing.*;

public class ViewerFour extends JFrame {
    JButton searchButton_;
    JButton exitButton_;

    public ViewerFour() {
        super("Database Viewer Four");
        searchButton_ = new JButton("Search");
        exitButton_ = new JButton("Exit");
        add(searchButton_);
        add(exitButton_);
        pack();
        setVisible(true);
    }

}

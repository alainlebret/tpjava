package tp04.swing;

import javax.swing.*;

public class ViewerThree extends JFrame {
    JButton searchButton_;
    JButton exitButton_;

    public ViewerThree() {
        super("Database Viewer Three");
        searchButton_ = new JButton("Search");
        exitButton_ = new JButton("Exit");
        add(searchButton_);
        add(exitButton_);
        setVisible(true);
    }

}

package tp04.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewerSix extends JFrame implements ActionListener {
    JButton searchButton_;
    JButton exitButton_;

    public ViewerSix() {
        super("Database Viewer Six");
        searchButton_ = new JButton("Search");
        exitButton_ = new JButton("Exit");
        setLayout(new FlowLayout());
        add(searchButton_);
        add(exitButton_);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

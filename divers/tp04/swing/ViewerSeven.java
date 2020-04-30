package tp04.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewerSeven extends JFrame implements ActionListener {
    JButton searchButton_;
    JButton exitButton_;

    public ViewerSeven() {
        super("Database Viewer Seven");
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
        if (e.getSource() == searchButton_) {
            // do your best with this button
            System.out.println("The search button has been pressed.");
        }
        if (e.getSource() == exitButton_) {
            System.exit(0);
        }
    }

}

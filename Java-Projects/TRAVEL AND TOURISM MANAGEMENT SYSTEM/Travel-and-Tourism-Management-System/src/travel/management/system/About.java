package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    JLabel headingLabel;
    TextArea aboutText;
    JButton exitButton;

    public About() {

        setSize(600, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);

        headingLabel = new JLabel("About Project");
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        headingLabel.setForeground(new Color(0, 102, 204));
        headingLabel.setBounds(190, 20, 250, 40);
        add(headingLabel);

        String content = "The objective of the Travel and Tourism Management System project is to "
                + "develop a system that automates the processes and activities of a travel agency. "
                + "The purpose is to design a system that allows users to perform all operations related to travel.\n\n"
                + "Key Benefits:\n"
                + "• Accurate information\n"
                + "• Simplifies manual tasks\n"
                + "• Minimizes paperwork\n"
                + "• Up-to-date information access\n"
                + "• Friendly environment with warnings\n"
                + "• Track travelers' details easily\n"
                + "• Manages destinations, packages, and pricing\n"
                + "• Enhances customer experience with fast processing\n\n"
                + "This application helps users access travel-related information and manage tours "
                + "with ease, including agency and destination details.";

        aboutText = new TextArea(content, 10, 40, Scrollbar.VERTICAL);
        aboutText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        aboutText.setBackground(Color.WHITE);
        aboutText.setForeground(new Color(50, 50, 50));
        aboutText.setEditable(false);
        aboutText.setBounds(50, 80, 480, 370);
        add(aboutText);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        exitButton.setBackground(new Color(255, 51, 51));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBounds(240, 470, 100, 35);
        exitButton.addActionListener(this);
        add(exitButton);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new About();
    }
}

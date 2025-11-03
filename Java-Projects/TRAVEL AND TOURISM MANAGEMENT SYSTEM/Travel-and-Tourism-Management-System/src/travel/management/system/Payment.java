package travel.management.system;

import java.awt.*;
import java.net.URI;
import javax.swing.*;

public class Payment extends JFrame {

    private JLabel bkashImageLabel;
    private JLabel nogodImageLabel;

    public Payment() {
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout(10, 10));

        JLabel headerLabel = new JLabel("Choose Payment Method", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Raleway", Font.BOLD, 32));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(headerLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 40, 0));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));


        JPanel bkashPanel = new JPanel(new BorderLayout(0, 20));
        bkashPanel.setBackground(Color.WHITE);

        try {
            ImageIcon bkashIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bkash.png"));
            Image bkashImg = bkashIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            bkashImageLabel = new JLabel(new ImageIcon(bkashImg));
        } catch (Exception ex) {
            bkashImageLabel = new JLabel("Bkash Image Not Found", SwingConstants.CENTER);
            bkashImageLabel.setPreferredSize(new Dimension(200, 200));
            bkashImageLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }

        bkashPanel.add(bkashImageLabel, BorderLayout.CENTER);

        JButton bkashBtn = new JButton("Pay with Bkash");
        bkashBtn.setFont(new Font("Raleway", Font.BOLD, 24));
        bkashBtn.setBackground(new Color(220, 53, 69));
        bkashBtn.setForeground(Color.WHITE);
        bkashBtn.setFocusPainted(false);
        bkashBtn.addActionListener(e -> openUrl("https://www.bkash.com/"));
        bkashPanel.add(bkashBtn, BorderLayout.SOUTH);

       
        JPanel nogodPanel = new JPanel(new BorderLayout(0, 20));
        nogodPanel.setBackground(Color.WHITE);

        try {
            ImageIcon nogodIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/nogod.png"));
            Image nogodImg = nogodIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            nogodImageLabel = new JLabel(new ImageIcon(nogodImg));
        } catch (Exception ex) {
            nogodImageLabel = new JLabel("Nogod Image Not Found", SwingConstants.CENTER);
            nogodImageLabel.setPreferredSize(new Dimension(200, 200));
            nogodImageLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }

        nogodPanel.add(nogodImageLabel, BorderLayout.CENTER);

        JButton nogodBtn = new JButton("Pay with Nogod");
        nogodBtn.setFont(new Font("Raleway", Font.BOLD, 24));
        nogodBtn.setBackground(new Color(255, 193, 7));
        nogodBtn.setForeground(Color.BLACK);
        nogodBtn.setFocusPainted(false);
        nogodBtn.addActionListener(e -> openUrl("https://www.nagad.com.bd/"));
        nogodPanel.add(nogodBtn, BorderLayout.SOUTH);

        contentPanel.add(bkashPanel);
        contentPanel.add(nogodPanel);
        add(contentPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Raleway", Font.BOLD, 18));
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
        bottomPanel.add(backBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void openUrl(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to open the payment page.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Payment().setVisible(true));
    }
}

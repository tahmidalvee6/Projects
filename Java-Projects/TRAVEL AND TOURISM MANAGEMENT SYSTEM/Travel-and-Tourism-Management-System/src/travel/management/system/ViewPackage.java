package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class ViewPackage extends JFrame {

    private JPanel contentPane;
    private String username;

    public ViewPackage(String username) {
        this.username = username;

        setBounds(400, 150, 1000, 500);  
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(480, 340, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(480, 60, 480, 340);
        contentPane.add(la1);

        
        JLabel lblTitle = new JLabel("VIEW PACKAGE DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.BOLD, 22));
        lblTitle.setBounds(88, 20, 400, 40);
        contentPane.add(lblTitle);

        
        JLabel lbUsername = new JLabel("Username :");
        lbUsername.setBounds(35, 80, 200, 25);
        contentPane.add(lbUsername);

        JLabel lUsername = new JLabel();
        lUsername.setBounds(180, 80, 250, 25);
        contentPane.add(lUsername);

        
        JLabel lblPackage = new JLabel("Package :");
        lblPackage.setBounds(35, 130, 200, 25);
        contentPane.add(lblPackage);

        JLabel lPackage = new JLabel();
        lPackage.setBounds(180, 130, 250, 25);
        contentPane.add(lPackage);

        
        JLabel lbPersons = new JLabel("Number of Persons :");
        lbPersons.setBounds(35, 180, 200, 25);
        contentPane.add(lbPersons);

        JLabel lPersons = new JLabel();
        lPersons.setBounds(180, 180, 250, 25);
        contentPane.add(lPersons);

        
        JLabel lblPrice = new JLabel("Price :");
        lblPrice.setBounds(35, 230, 200, 25);
        contentPane.add(lblPrice);

        JLabel lPrice = new JLabel();
        lPrice.setBounds(180, 230, 250, 25);
        contentPane.add(lPrice);

        
        try {
            DBConnection c = new DBConnection();
            String query = "SELECT * FROM bookPackage WHERE username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                lUsername.setText(rs.getString("username"));
                lPackage.setText(rs.getString("package"));
                lPersons.setText(rs.getString("persons"));
                lPrice.setText(rs.getString("price"));
            } else {
                JOptionPane.showMessageDialog(null, "No package found for user: " + username);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Back button
        JButton btnExit = new JButton("Back");
        btnExit.setBounds(120, 300, 120, 35);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        btnExit.addActionListener(e -> setVisible(false));

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewPackage("someusername");  
    }
}

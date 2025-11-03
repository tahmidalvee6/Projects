package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class ViewBookedHotel extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewBookedHotel frame = new ViewBookedHotel("testuser"); 
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewBookedHotel(String username) {
        setBounds(580, 220, 850, 550); 
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 350, 350);
        contentPane.add(la1);

        
        JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);

        
        JLabel lb3 = new JLabel("Username :");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        JLabel l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Name :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number of Persons :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("Number of Days :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);

        JLabel lblGender = new JLabel("AC / Non-AC :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Food Included (Yes/No) :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);

        
        try {
            DBConnection c = new DBConnection();
            String query = "SELECT username, hotel, persons, days, ac, food FROM bookHotel WHERE username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                l1.setText(rs.getString("username"));
                l2.setText(rs.getString("hotel"));
                l3.setText(rs.getString("persons"));
                l4.setText(rs.getString("days"));
                l5.setText(rs.getString("ac"));
                l6.setText(rs.getString("food"));
             
            } else {
                JOptionPane.showMessageDialog(null, "No booking found for user: " + username);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        JButton btnExit = new JButton("Back");
        btnExit.setBounds(160, 350, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
        btnExit.addActionListener(e -> setVisible(false));

        getContentPane().setBackground(Color.WHITE);
    }
}

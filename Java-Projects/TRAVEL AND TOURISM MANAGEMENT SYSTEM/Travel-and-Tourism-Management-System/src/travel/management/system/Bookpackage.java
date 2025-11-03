package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Bookpackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField t1;
    String username;
    JLabel labelusername, labelprice;
    JButton checkprice, bookpackage, back;

    public Bookpackage(String username) {
        this.username = username;

        setBounds(400, 150, 1200, 500);  // Frame size increased here
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Heading
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(100, 10, 200, 30);
        add(text);

        // Username label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 200, 20);
        add(labelusername);

        // Package selection
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("SAJEK VALLEY PACKAGE");
        cpackage.add("COX'S BAZAR GETAWAY");
        cpackage.add("SAINT MARTIN ISLAND TOUR");
        cpackage.add("SUNDARBANS EXPLORER");
        cpackage.add("RANGAMATI HILL STATION");
        cpackage.setBounds(250, 110, 300, 25);
        add(cpackage);

        // Total persons
        JLabel lbltotalpersons = new JLabel("Total Persons");
        lbltotalpersons.setBounds(40, 150, 150, 25);
        add(lbltotalpersons);

        t1 = new JTextField("1");
        t1.setBounds(250, 150, 300, 25);
        add(t1);

        // Total price label and value
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(40, 190, 150, 20);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(250, 190, 200, 25);
        labelprice.setForeground(Color.RED);
        add(labelprice);

        // Buttons
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 240, 140, 30);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(220, 240, 140, 30);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(380, 240, 140, 30);
        back.addActionListener(this);
        add(back);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(650, 70, 500, 300);  
        add(l1);

        
        try {
            DBConnection c = new DBConnection();
            String query = "SELECT username FROM customer WHERE username = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
            } else {
                JOptionPane.showMessageDialog(this, "User info not found for username: " + username);
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("SAJEK VALLEY PACKAGE")) cost = 15000;
            else if (pack.equals("COX'S BAZAR GETAWAY")) cost = 22000;
            else if (pack.equals("SAINT MARTIN ISLAND TOUR")) cost = 18000;
            else if (pack.equals("SUNDARBANS EXPLORER")) cost = 25000;
            else if (pack.equals("RANGAMATI HILL STATION")) cost = 16000;

            try {
                int persons = Integer.parseInt(t1.getText());
                if (persons <= 0) throw new NumberFormatException();
                int totalCost = cost * persons;
                labelprice.setText("Tk " + totalCost);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Enter a valid number of persons", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == bookpackage) {
            try {
                DBConnection c = new DBConnection();
                String query = "INSERT INTO bookPackage (username, package, persons, price) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, labelusername.getText());
                pst.setString(2, cpackage.getSelectedItem());
                pst.setString(3, t1.getText());
                pst.setString(4, labelprice.getText());
                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Booking failed: " + e.getMessage());
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Bookpackage("testuser");
    }
}

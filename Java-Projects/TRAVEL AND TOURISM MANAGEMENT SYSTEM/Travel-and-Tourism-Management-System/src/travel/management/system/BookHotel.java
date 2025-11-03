package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import javax.swing.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice locationChoice, hotelChoice, acChoice, foodChoice;
    JTextField personsField, daysField;
    JLabel lUsername, lId, lNumber, lPhone;
    JButton bookButton, backButton;
    String username;

    public BookHotel(String username) {
        this.username = username;

        setBounds(250, 100, 900, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("BOOK HOTEL");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(120, 10, 200, 30);
        add(title);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 70, 100, 20);
        add(lblUsername);

        lUsername = new JLabel(username);
        lUsername.setBounds(150, 70, 150, 20);
        add(lUsername);

        JLabel lblLocation = new JLabel("Location");
        lblLocation.setBounds(40, 110, 100, 20);
        add(lblLocation);

        locationChoice = new Choice();
        locationChoice.add("Dhaka");
        locationChoice.add("Chittagong");
        locationChoice.add("Cox’s Bazar");
        locationChoice.add("Sylhet");
        locationChoice.add("Rajshahi");
        locationChoice.setBounds(150, 110, 100, 20);
        add(locationChoice);

        JLabel lblHotel = new JLabel("Hotel");
        lblHotel.setBounds(40, 150, 100, 20);
        add(lblHotel);

        hotelChoice = new Choice();
        hotelChoice.add("Hotel Sea Crown");
        hotelChoice.add("Long Beach Hotel");
        hotelChoice.add("Radisson Blu");
        hotelChoice.add("Hotel Sarina");
        hotelChoice.setBounds(150, 150, 120, 20);
        add(hotelChoice);

        JLabel lblPersons = new JLabel("Total Persons");
        lblPersons.setBounds(40, 190, 100, 20);
        add(lblPersons);

        personsField = new JTextField("1");
        personsField.setBounds(150, 190, 100, 20);
        add(personsField);

        JLabel lblDays = new JLabel("No. of Days");
        lblDays.setBounds(40, 230, 100, 20);
        add(lblDays);

        daysField = new JTextField("1");
        daysField.setBounds(150, 230, 100, 20);
        add(daysField);

        JLabel lblAc = new JLabel("AC / Non-AC");
        lblAc.setBounds(40, 270, 100, 20);
        add(lblAc);

        acChoice = new Choice();
        acChoice.add("AC");
        acChoice.add("Non-AC");
        acChoice.setBounds(150, 270, 100, 20);
        add(acChoice);

        JLabel lblFood = new JLabel("Food Included");
        lblFood.setBounds(40, 310, 100, 20);
        add(lblFood);

        foodChoice = new Choice();
        foodChoice.add("Yes");
        foodChoice.add("No");
        foodChoice.setBounds(150, 310, 100, 20);
        add(foodChoice);

        
        bookButton = new JButton("Book");
        bookButton.setBackground(Color.BLACK);
        bookButton.setForeground(Color.WHITE);
        bookButton.setBounds(50, 370, 100, 25);
        bookButton.addActionListener(this);
        add(bookButton);

        
        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(170, 370, 100, 25);
        backButton.addActionListener(this);
        add(backButton);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(i2));
        l1.setBounds(400, 100, 450, 300);
        add(l1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bookButton) {
            String location = locationChoice.getSelectedItem();
            String hotel = hotelChoice.getSelectedItem();
            String persons = personsField.getText();
            String days = daysField.getText();
            String ac = acChoice.getSelectedItem();
            String food = foodChoice.getSelectedItem();

            try {
                DBConnection c = new DBConnection();
                String query = "INSERT INTO bookhotel (username, location, hotel, persons, days, ac, food) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, location);
                pst.setString(3, hotel);
                pst.setInt(4, Integer.parseInt(persons));
                pst.setInt(5, Integer.parseInt(days));
                pst.setString(6, ac);
                pst.setString(7, food);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Booking failed: " + e.getMessage());
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("Tahmid");
    }
}

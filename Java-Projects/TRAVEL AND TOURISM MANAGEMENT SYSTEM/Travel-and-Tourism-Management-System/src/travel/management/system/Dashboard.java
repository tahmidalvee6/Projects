package travel.management.system;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;

public class Dashboard extends JFrame {

    private String username;

    public Dashboard(String username) throws SQLException {
        this.username = username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 128, 128));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 128, 128));
        p2.setBounds(0, 65, 300, 935);
        add(p2);

        int buttonHeight = 52;

        JButton addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, buttonHeight * 0, 300, buttonHeight);
        styleButton(addPersonalDetails, 60);
        p2.add(addPersonalDetails);

        JButton updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, buttonHeight * 1, 300, buttonHeight);
        styleButton(updatePersonalDetails, 30);
        p2.add(updatePersonalDetails);

        JButton viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, buttonHeight * 2, 300, buttonHeight);
        styleButton(viewPersonalDetails, 60);
        p2.add(viewPersonalDetails);

        JButton deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, buttonHeight * 3, 300, buttonHeight);
        styleButton(deletePersonalDetails, 40);
        p2.add(deletePersonalDetails);

        JButton destinations = new JButton("Destinations");
        destinations.setBounds(0, buttonHeight * 4, 300, buttonHeight);
        styleButton(destinations, 125);
        p2.add(destinations);

        JButton checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0, buttonHeight * 5, 300, buttonHeight);
        styleButton(checkPackages, 110);
        p2.add(checkPackages);

        JButton bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, buttonHeight * 6, 300, buttonHeight);
        styleButton(bookPackage, 120);
        p2.add(bookPackage);

        JButton viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, buttonHeight * 7, 300, buttonHeight);
        styleButton(viewPackage, 120);
        p2.add(viewPackage);

        JButton viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, buttonHeight * 8, 300, buttonHeight);
        styleButton(viewHotels, 130);
        p2.add(viewHotels);

        JButton bookHotel = new JButton("Book Hotels");
        bookHotel.setBounds(0, buttonHeight * 9, 300, buttonHeight);
        styleButton(bookHotel, 140);
        p2.add(bookHotel);

        JButton viewBookedHotel = new JButton("View Booked Hotels");
        viewBookedHotel.setBounds(0, buttonHeight * 10, 300, buttonHeight);
        styleButton(viewBookedHotel, 70);
        p2.add(viewBookedHotel);

        JButton payments = new JButton("Payments");
        payments.setBounds(0, buttonHeight * 11, 300, buttonHeight);
        styleButton(payments, 155);
        p2.add(payments);

        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0, buttonHeight * 12, 300, buttonHeight);
        styleButton(calculator, 145);
        p2.add(calculator);

        JButton about = new JButton("About");
        about.setBounds(0, buttonHeight * 13, 300, buttonHeight);
        styleButton(about, 175);
        p2.add(about);

        JButton viewCustomers = new JButton("View Customers");
        viewCustomers.setBounds(0, buttonHeight * 14, 300, buttonHeight);
        styleButton(viewCustomers, 140);
        p2.add(viewCustomers);

        
        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(300, 65, 1300, 935);  
        add(p3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dashboard.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1300, 935, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(new ImageIcon(i5));
        image.setBounds(0, 0, 1300, 935);
        p3.add(image);

        JLabel text = new JLabel("Travel And Tourism Management System");
        text.setBounds(150, 70, 1000, 70);  
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 50));
        image.add(text);

        
        checkPackages.addActionListener(e -> new CheckPackage().setVisible(true));
        destinations.addActionListener(e -> new Destination().setVisible(true));
        calculator.addActionListener(e -> new Calculator().setVisible(true));
        payments.addActionListener(e -> new Payment().setVisible(true));
        viewHotels.addActionListener(e -> new CheckHotels().setVisible(true));
        about.addActionListener(e -> new About().setVisible(true));
        bookPackage.addActionListener(e -> new Bookpackage(username).setVisible(true));
        bookHotel.addActionListener(e -> new BookHotel(username).setVisible(true));
        viewBookedHotel.addActionListener(e -> new ViewBookedHotel(username).setVisible(true));;
        addPersonalDetails.addActionListener(e -> new AddCustomer(username).setVisible(true));
        updatePersonalDetails.addActionListener(e -> new UpdateCustomer(username).setVisible(true));
        viewPackage.addActionListener(e -> new ViewPackage(username).setVisible(true));
        deletePersonalDetails.addActionListener(e -> new DeleteCustomer(username).setVisible(true));
        viewPersonalDetails.addActionListener(e -> {
        try {
            new ViewCustomer(username).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to open View Personal Details window.");
    }
});

        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void styleButton(JButton button, int rightMargin) {
        button.setBackground(new Color(0, 128, 128));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setMargin(new Insets(0, 0, 0, rightMargin));
    }

    public static void main(String[] args) {
        try {
            new Dashboard("username");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

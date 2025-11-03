package travel.management.system;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class ViewCustomer extends JFrame {

    private JLabel lUsername, lIdType, lIdNumber, lName, lGender, lCountry, lAddress, lPhone, lEmail;

    public ViewCustomer(String username) {
        setBounds(580, 220, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("VIEW CUSTOMER DETAILS");
        heading.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        heading.setBounds(118, 11, 300, 53);
        add(heading);

       
        int labelX = 35, labelWidth = 150, labelHeight = 25;
        int valueX = 200, valueWidth = 250;

        add(new JLabel("Username:")).setBounds(labelX, 70, labelWidth, labelHeight);
        lUsername = new JLabel();
        lUsername.setBounds(valueX, 70, valueWidth, labelHeight);
        add(lUsername);

        add(new JLabel("ID Type:")).setBounds(labelX, 110, labelWidth, labelHeight);
        lIdType = new JLabel();
        lIdType.setBounds(valueX, 110, valueWidth, labelHeight);
        add(lIdType);

        add(new JLabel("ID Number:")).setBounds(labelX, 150, labelWidth, labelHeight);
        lIdNumber = new JLabel();
        lIdNumber.setBounds(valueX, 150, valueWidth, labelHeight);
        add(lIdNumber);

        add(new JLabel("Name:")).setBounds(labelX, 190, labelWidth, labelHeight);
        lName = new JLabel();
        lName.setBounds(valueX, 190, valueWidth, labelHeight);
        add(lName);

        add(new JLabel("Gender:")).setBounds(labelX, 230, labelWidth, labelHeight);
        lGender = new JLabel();
        lGender.setBounds(valueX, 230, valueWidth, labelHeight);
        add(lGender);

        add(new JLabel("Country:")).setBounds(labelX, 270, labelWidth, labelHeight);
        lCountry = new JLabel();
        lCountry.setBounds(valueX, 270, valueWidth, labelHeight);
        add(lCountry);

        add(new JLabel("Address:")).setBounds(labelX, 310, labelWidth, labelHeight);
        lAddress = new JLabel();
        lAddress.setBounds(valueX, 310, valueWidth, labelHeight);
        add(lAddress);

        add(new JLabel("Phone:")).setBounds(labelX, 350, labelWidth, labelHeight);
        lPhone = new JLabel();
        lPhone.setBounds(valueX, 350, valueWidth, labelHeight);
        add(lPhone);

        add(new JLabel("Email:")).setBounds(labelX, 390, labelWidth, labelHeight);
        lEmail = new JLabel();
        lEmail.setBounds(valueX, 390, valueWidth, labelHeight);
        add(lEmail);

        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(150, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(e -> setVisible(false));
        add(btnBack);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/viewpersonaldetails.jpg"));
        Image i3 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450, 50, 350, 350);
        add(la1);

      
        fetchCustomerDetails(username);

        setVisible(true);
    }

    private void fetchCustomerDetails(String username) {
        try {
            DBConnection conn = new DBConnection();
            String query = "SELECT * FROM customer WHERE username = ?";
            var pst = conn.c.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lUsername.setText(rs.getString("username"));
                lIdType.setText(rs.getString("id_type"));
                lIdNumber.setText(rs.getString("id_number"));
                lName.setText(rs.getString("name"));
                lGender.setText(rs.getString("gender"));
                lCountry.setText(rs.getString("country"));
                lAddress.setText(rs.getString("address"));
                lPhone.setText(rs.getString("phone"));
                lEmail.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(this, "No customer found with username: " + username);
                setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching customer details: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("someUsername");  
    }
}

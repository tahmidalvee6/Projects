package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.*;

public class AddCustomer extends JFrame {

    private JTextField tUsername, tIdNumber, tName, tCountry, tAddress, tPhone, tEmail;
    private JComboBox<String> comboBoxIdType;
    private JRadioButton rMale, rFemale;
    private ButtonGroup genderGroup;

    public AddCustomer(String username) {
        setBounds(580, 220, 850, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/newcustomer.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(450,40,450,420);
        add(l1);
		

        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        heading.setBounds(118, 11, 260, 53);
        add(heading);

        
        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setBounds(35, 70, 200, 14);
        add(lblUsername);

        tUsername = new JTextField(username);
        tUsername.setBounds(271, 70, 150, 20);
        tUsername.setEditable(false);  
        add(tUsername);

        
        JLabel lblIdType = new JLabel("ID Type :");
        lblIdType.setBounds(35, 110, 200, 14);
        add(lblIdType);

        comboBoxIdType = new JComboBox<>(new String[]{"Passport", "National ID", "Birth Certificate", "Driving license"});
        comboBoxIdType.setBounds(271, 110, 150, 20);
        add(comboBoxIdType);

        
        JLabel lblIdNumber = new JLabel("ID Number :");
        lblIdNumber.setBounds(35, 150, 200, 14);
        add(lblIdNumber);

        tIdNumber = new JTextField();
        tIdNumber.setBounds(271, 150, 150, 20);
        add(tIdNumber);

        
        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(35, 190, 200, 14);
        add(lblName);

        tName = new JTextField();
        tName.setBounds(271, 190, 150, 20);
        add(tName);

        
        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        add(lblGender);

        rMale = new JRadioButton("Male");
        rMale.setBackground(Color.WHITE);
        rMale.setBounds(271, 230, 80, 20);
        add(rMale);

        rFemale = new JRadioButton("Female");
        rFemale.setBackground(Color.WHITE);
        rFemale.setBounds(350, 230, 100, 20);
        add(rFemale);

        genderGroup = new ButtonGroup();
        genderGroup.add(rMale);
        genderGroup.add(rFemale);

        
        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        add(lblCountry);

        tCountry = new JTextField();
        tCountry.setBounds(271, 270, 150, 20);
        add(tCountry);

        
        JLabel lblAddress = new JLabel("Permanent Address :");
        lblAddress.setBounds(35, 310, 200, 14);
        add(lblAddress);

        tAddress = new JTextField();
        tAddress.setBounds(271, 310, 150, 20);
        add(tAddress);

        
        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setBounds(35, 350, 200, 14);
        add(lblPhone);

        tPhone = new JTextField();
        tPhone.setBounds(271, 350, 150, 20);
        add(tPhone);

        
        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(35, 390, 200, 14);
        add(lblEmail);

        tEmail = new JTextField();
        tEmail.setBounds(271, 390, 150, 20);
        add(tEmail);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(100, 430, 120, 30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        add(btnAdd);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(260, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);

        
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        btnBack.addActionListener(e -> setVisible(false));

        setVisible(true);
    }

    private void addCustomer() {
        String username = tUsername.getText().trim();
        String idType = (String) comboBoxIdType.getSelectedItem();
        String idNumber = tIdNumber.getText().trim();
        String name = tName.getText().trim();
        String gender = rMale.isSelected() ? "Male" : rFemale.isSelected() ? "Female" : "";
        String country = tCountry.getText().trim();
        String address = tAddress.getText().trim();
        String phone = tPhone.getText().trim();
        String email = tEmail.getText().trim();

        if (username.isEmpty() || idNumber.isEmpty() || name.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all mandatory fields (username, id number, name, gender).");
            return;
        }

        try {
            DBConnection conn = new DBConnection();
            String sql = "INSERT INTO customer(username, id_type, id_number, name, gender, country, address, phone, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.c.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, idType);
            pst.setString(3, idNumber);
            pst.setString(4, name);
            pst.setString(5, gender);
            pst.setString(6, country);
            pst.setString(7, address);
            pst.setString(8, phone);
            pst.setString(9, email);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Customer Added Successfully");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add customer");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}

package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
    private String username; 

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {              //GUI freeze hoya thekaite use hoy
            try {
                UpdateCustomer frame = new UpdateCustomer("testuser"); 
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UpdateCustomer(String username) {
        this.username = username;  

        setBounds(580, 220, 850, 550);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/update.png"));
        Image i3 = i1.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 40, 200, 400);
        add(l1);

        JLabel lblName = new JLabel("UPDATE CUSTOMER DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel l3 = new JLabel("Username :");
        l3.setBounds(35, 70, 200, 14);
        contentPane.add(l3);

        t1 = new JTextField();
        t1.setBounds(271, 70, 150, 20);
        t1.setEditable(false);  
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel lblIdType = new JLabel("ID Type :");
        lblIdType.setBounds(35, 110, 200, 14);
        contentPane.add(lblIdType);

        t2 = new JTextField();
        t2.setBounds(271, 110, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel lblIdNumber = new JLabel("ID Number :");
        lblIdNumber.setBounds(35, 150, 200, 14);
        contentPane.add(lblIdNumber);

        t3 = new JTextField();
        t3.setBounds(271, 150, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel lblNameLabel = new JLabel("Name :");
        lblNameLabel.setBounds(35, 190, 200, 14);
        contentPane.add(lblNameLabel);

        t4 = new JTextField();
        t4.setBounds(271, 190, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        t5 = new JTextField();
        t5.setBounds(271, 230, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        t6 = new JTextField();
        t6.setBounds(271, 270, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JLabel lblAddress = new JLabel("Permanent Address :");
        lblAddress.setBounds(35, 310, 200, 14);
        contentPane.add(lblAddress);

        t7 = new JTextField();
        t7.setBounds(271, 310, 150, 20);
        contentPane.add(t7);
        t7.setColumns(10);

        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setBounds(35, 350, 200, 14);
        contentPane.add(lblPhone);

        t8 = new JTextField();
        t8.setBounds(271, 350, 150, 20);
        contentPane.add(t8);
        t8.setColumns(10);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(35, 390, 200, 14);
        contentPane.add(lblEmail);

        t9 = new JTextField();
        t9.setBounds(271, 390, 150, 20);
        contentPane.add(t9);
        t9.setColumns(10);

        
        try {
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            if (rs.next()) {
                t1.setText(rs.getString("username"));
                t2.setText(rs.getString("id_type"));
                t3.setText(rs.getString("id_number"));  
                t4.setText(rs.getString("name"));
                t5.setText(rs.getString("gender"));
                t6.setText(rs.getString("country"));
                t7.setText(rs.getString("address"));
                t8.setText(rs.getString("phone"));
                t9.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 430, 120, 30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DBConnection c = new DBConnection();
                    String sql = "UPDATE customer SET id_type=?, id_number=?, name=?, gender=?, country=?, address=?, phone=?, email=? WHERE username=?";
                    PreparedStatement pst = c.c.prepareStatement(sql);
                    pst.setString(1, t2.getText());
                    pst.setString(2, t3.getText());
                    pst.setString(3, t4.getText());
                    pst.setString(4, t5.getText());
                    pst.setString(5, t6.getText());
                    pst.setString(6, t7.getText());
                    pst.setString(7, t8.getText());
                    pst.setString(8, t9.getText());
                    pst.setString(9, username);

                    int rowsUpdated = pst.executeUpdate();

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Update failed: Username not found");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating customer details");
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(260, 430, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        contentPane.add(btnBack);

        btnBack.addActionListener(e -> setVisible(false));

        getContentPane().setBackground(Color.WHITE);
    }

    public UpdateCustomer() {
        
    }
}

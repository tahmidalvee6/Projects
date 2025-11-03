package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckHotels extends JFrame implements Runnable {

    JLabel l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JLabel caption;
    Thread th;

    public void run() {
        try {
            l2.setVisible(true);
            caption.setText("Sajek Resort, Sajek");
            Thread.sleep(2800);
            l2.setVisible(false);

            l3.setVisible(true);
            caption.setText("Hilltop Sajek View Hotel, Sajek");
            Thread.sleep(2800);
            l3.setVisible(false);

            l4.setVisible(true);
            caption.setText("Hotel Sea Pearl, Cox's Bazar");
            Thread.sleep(2800);
            l4.setVisible(false);

            l5.setVisible(true);
            caption.setText("Long Beach Hotel, Cox's Bazar");
            Thread.sleep(2800);
            l5.setVisible(false);

            l6.setVisible(true);
            caption.setText("Blue Coral Island Resort, Saint Martin");
            Thread.sleep(2800);
            l6.setVisible(false);

            l7.setVisible(true);
            caption.setText("Seashell Saint Martin, Saint Martin");
            Thread.sleep(2800);
            l7.setVisible(false);

            l8.setVisible(true);
            caption.setText("Sundarban Tiger Camp, Sundarbans");
            Thread.sleep(2800);
            l8.setVisible(false);

            l9.setVisible(true);
            caption.setText("Bohu Beach Resort, Sundarbans");
            Thread.sleep(2800);
            l9.setVisible(false);

            l10.setVisible(true);
            caption.setText("Hotel Hill View, Rangamati");
            Thread.sleep(2800);
            l10.setVisible(false);

            l11.setVisible(true);
            caption.setText("Royal Lake Resort, Rangamati");
            Thread.sleep(2800);
            l11.setVisible(false);

            this.setVisible(false);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CheckHotels() {
        setBounds(0, 0, 900, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(220, 250, 250));
        setLayout(null);

        th = new Thread(this);

        caption = new JLabel();
        caption.setBounds(50, 550, 800, 70);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(caption);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l2 = new JLabel(new ImageIcon(i2));
        l2.setBounds(0, 0, 900, 700);
        l2.setVisible(false);
        add(l2);

       
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l3 = new JLabel(new ImageIcon(i5));
        l3.setBounds(0, 0, 900, 700);
        l3.setVisible(false);
        add(l3);

      
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel3.jpg"));
        Image i8 = i7.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l4 = new JLabel(new ImageIcon(i8));
        l4.setBounds(0, 0, 900, 700);
        l4.setVisible(false);
        add(l4);

        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel4.jpg"));
        Image i11 = i10.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l5 = new JLabel(new ImageIcon(i11));
        l5.setBounds(0, 0, 900, 700);
        l5.setVisible(false);
        add(l5);

        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel5.jpg"));
        Image i14 = i13.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l6 = new JLabel(new ImageIcon(i14));
        l6.setBounds(0, 0, 900, 700);
        l6.setVisible(false);
        add(l6);

        
        
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel6.jpg"));
        Image i17 = i16.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l7 = new JLabel(new ImageIcon(i17));
        l7.setBounds(0, 0, 900, 700);
        l7.setVisible(false);
        add(l7);

      
        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel7.jpg"));
        Image i20 = i19.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l8 = new JLabel(new ImageIcon(i20));
        l8.setBounds(0, 0, 900, 700);
        l8.setVisible(false);
        add(l8);

        
        ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel8.jpg"));
        Image i23 = i22.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l9 = new JLabel(new ImageIcon(i23));
        l9.setBounds(0, 0, 900, 700);
        l9.setVisible(false);
        add(l9);

        
        ImageIcon i25 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel9.jpg"));
        Image i26 = i25.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l10 = new JLabel(new ImageIcon(i26));
        l10.setBounds(0, 0, 900, 700);
        l10.setVisible(false);
        add(l10);

        
        ImageIcon i28 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/hotel10.jpg"));
        Image i29 = i28.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l11 = new JLabel(new ImageIcon(i29));
        l11.setBounds(0, 0, 900, 700);
        l11.setVisible(false);
        add(l11);
        
        th.start();
    }

    public static void main(String[] args) {
        new CheckHotels().setVisible(true);
    }
}

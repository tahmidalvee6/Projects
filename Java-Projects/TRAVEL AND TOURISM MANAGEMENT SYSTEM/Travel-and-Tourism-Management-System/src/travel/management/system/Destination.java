package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Destination extends JFrame implements Runnable {

    JLabel l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JLabel caption;
    Thread th;

    public void run() {
        try {
            l2.setVisible(true);
            caption.setText("Konglak Hill, Sajek");
            Thread.sleep(2800);
            l2.setVisible(false);

            l3.setVisible(true);
            caption.setText("Helipad Viewpoint, Sajek");
            Thread.sleep(2800);
            l3.setVisible(false);

            l4.setVisible(true);
            caption.setText("Inani Beach, Cox's Bazar");
            Thread.sleep(2800);
            l4.setVisible(false);

            l5.setVisible(true);
            caption.setText("Laboni Point, Cox's Bazar");
            Thread.sleep(2800);
            l5.setVisible(false);

            l6.setVisible(true);
            caption.setText("Coral Beach, Saint Martin");
            Thread.sleep(2800);
            l6.setVisible(false);

            l7.setVisible(true);
            caption.setText("Chhera Dwip, Saint Martin");
            Thread.sleep(2800);
            l7.setVisible(false);

            l8.setVisible(true);
            caption.setText("Kotka Beach, Sundarbans");
            Thread.sleep(2800);
            l8.setVisible(false);

            l9.setVisible(true);
            caption.setText("Harbaria Eco Tourism, Sundarbans");
            Thread.sleep(2800);
            l9.setVisible(false);

            l10.setVisible(true);
            caption.setText("Kaptai Lake, Rangamati");
            Thread.sleep(2800);
            l10.setVisible(false);

            l11.setVisible(true);
            caption.setText("Hanging Bridge, Rangamati");
            Thread.sleep(2800);
            l11.setVisible(false);

            this.setVisible(false);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Destination() {
        setBounds(0, 0, 900, 700);
        setLocationRelativeTo(null); 
        getContentPane().setBackground(new Color(220, 250, 250));
        setLayout(null);

        th = new Thread(this);

        caption = new JLabel();
        caption.setBounds(50, 550, 800, 70);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.BOLD, 36));
        add(caption);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l2 = new JLabel(new ImageIcon(i2));
        l2.setBounds(0, 0, 900, 700);
        add(l2);

       
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l3 = new JLabel(new ImageIcon(i5));
        l3.setBounds(0, 0, 900, 700);
        l3.setVisible(false);
        add(l3);

       
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest3.jpg"));
        Image i8 = i7.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l4 = new JLabel(new ImageIcon(i8));
        l4.setBounds(0, 0, 900, 700);
        l4.setVisible(false);
        add(l4);

        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest4.jpg"));
        Image i11 = i10.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l5 = new JLabel(new ImageIcon(i11));
        l5.setBounds(0, 0, 900, 700);
        l5.setVisible(false);
        add(l5);

        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest5.jpg"));
        Image i14 = i13.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l6 = new JLabel(new ImageIcon(i14));
        l6.setBounds(0, 0, 900, 700);
        l6.setVisible(false);
        add(l6);

        
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest6.jpg"));
        Image i17 = i16.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l7 = new JLabel(new ImageIcon(i17));
        l7.setBounds(0, 0, 900, 700);
        l7.setVisible(false);
        add(l7);

        
        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest7.jpg"));
        Image i20 = i19.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l8 = new JLabel(new ImageIcon(i20));
        l8.setBounds(0, 0, 900, 700);
        l8.setVisible(false);
        add(l8);

        
        ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest8.jpg"));
        Image i23 = i22.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l9 = new JLabel(new ImageIcon(i23));
        l9.setBounds(0, 0, 900, 700);
        l9.setVisible(false);
        add(l9);

        
        ImageIcon i25 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest9.jpg"));
        Image i26 = i25.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l10 = new JLabel(new ImageIcon(i26));
        l10.setBounds(0, 0, 900, 700);
        l10.setVisible(false);
        add(l10);

        
        ImageIcon i28 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dest10.jpg"));
        Image i29 = i28.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        l11 = new JLabel(new ImageIcon(i29));
        l11.setBounds(0, 0, 900, 700);
        l11.setVisible(false);
        add(l11);

        th.start();
    }

    public static void main(String[] args) {
        new Destination().setVisible(true);
    }
}

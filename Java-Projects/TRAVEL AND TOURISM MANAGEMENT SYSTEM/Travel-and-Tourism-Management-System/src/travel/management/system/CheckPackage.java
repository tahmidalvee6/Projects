package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CheckPackage extends JFrame {
    public static void main(String[] args) {
        new CheckPackage().setVisible(true);
    }

    CheckPackage() {
        this.setBounds(300, 100, 900, 600);
        this.setVisible(true);

        String[] package1 = new String[]{
            "sajek.jpg", "SAJEK VALLEY PACKAGE", "4 days and 3 nights", "Hillside Camping", "Boat Ride in Rivers",
            "Local Tribal Culture", "Sightseeing & Photography", "Visit Meghla Waterfalls",
            "Traditional Food Experience", "BOOK NOW", "Seasonal Offer", "Tk 15000 only"
        };

        String[] package2 = new String[]{
            "coxsbazar.jpg", "COX'S BAZAR GETAWAY", "4 days and 3 nights", "Beach Resort Stay",
            "Sunrise & Sunset Viewing", "Visit Himchari Park", "Seafood Dinner", "Boat Ride on Inani Beach",
            "Relaxing Beach Time", "BOOK NOW", "Summer Special", "Tk 22000 only"
        };

        String[] package3 = new String[]{
            "saintmartin.jpg", "SAINT MARTIN ISLAND TOUR", "3 days and 2 nights", "Island Beach Stay",
            "Snorkeling and Diving", "Coral Reef Exploration", "Visit Coral Beaches", "Fresh Seafood Feast",
            "Boat Tours", "BOOK NOW", "Winter Special", "Tk 18000 only"
        };

        String[] package4 = new String[]{
            "sundarban.jpg", "SUNDARBANS EXPLORER", "5 days and 4 nights", "Boat Safari",
            "Mangrove Forest Walk", "Wildlife Spotting", "Local Village Visits", "Bird Watching",
            "Cultural Experience", "BOOK NOW", "Monsoon Offer", "Tk 25000 only"
        };

        String[] package5 = new String[]{
            "rangamati.jpg", "RANGAMATI HILL STATION", "3 days and 2 nights", "Boat Ride on Kaptai Lake",
            "Visit Tribal Villages", "Hiking and Trekking", "Waterfall Visit", "Traditional Handicraft Shopping",
            "Scenic Views", "BOOK NOW", "Festive Offer", "Tk 16000 only"
        };

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Package 1", null, createPackage(package1));
        tabbedPane.addTab("Package 2", null, createPackage(package2));
        tabbedPane.addTab("Package 3", null, createPackage(package3));
        tabbedPane.addTab("Package 4", null, createPackage(package4));
        tabbedPane.addTab("Package 5", null, createPackage(package5));

        this.add(tabbedPane, "Center");
    }

    public JPanel createPackage(String[] data) {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager) null);
        panel.setBackground(Color.WHITE);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/" + data[0]));
        Image img = icon.getImage().getScaledInstance(550, 300, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imgLabel = new JLabel(scaledIcon);
        imgLabel.setBounds(400, 0, 450, 300);
        panel.add(imgLabel);

        JLabel lblTitle = new JLabel(data[1]);
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBounds(30, 5, 350, 40);
        panel.add(lblTitle);

        
        for (int i = 2; i <= 8; i++) {
            JLabel label = new JLabel(data[i]);
            label.setForeground(Color.BLACK);
            label.setBounds(35, 60 + (i - 2) * 35, 300, 20);
            panel.add(label);
        }

       
        JLabel lblBook = new JLabel(data[9]);
        lblBook.setForeground(new Color(102, 178, 255)); 
        lblBook.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblBook.setBounds(35, 380, 200, 30);
        panel.add(lblBook);

        
        JLabel lblOffer = new JLabel(data[10]);
        lblOffer.setForeground(new Color(0, 153, 0));  
        lblOffer.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
        lblOffer.setBounds(35, 440, 300, 30);
        panel.add(lblOffer);

        
        JLabel lblPrice = new JLabel(data[11]);
        lblPrice.setForeground(new Color(204, 0, 0));  
        lblPrice.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
        lblPrice.setBounds(600, 440, 250, 30);
        panel.add(lblPrice);

        return panel;
    }
}

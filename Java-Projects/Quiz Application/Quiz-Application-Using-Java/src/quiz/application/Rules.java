package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Rules extends JFrame implements ActionListener{         // 3. Jframe ta extend krte hoise        
  
   
    String name;                                            
    JButton back, start;                                // 24. locallay set krsi

    Rules(String name) {                               // 2. constructor banaisi.. eikhane amra frame ta banabo

    this.name = name;
    setLayout(null);                            // 7. eta diye swing er j layout ta ase ta use krbo na bole dissi

    JLabel heading = new JLabel("Welcome " + name);                 // 8. akhn frame er modde kisu lekhar jnno eta use krsi
    heading.setBounds(50,20,700,45);                   // 9. lekhata set korar jnno...left theke 810 theke start hbe...upor theke 150 theke start hbe... nijer length hbe 300...width 20
    heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));          // 10. eta diye lekhatar font ta change krtesi
    add(heading);


    JLabel rules = new JLabel();                                                // 11. rules gular jnno akta JLabel banaisi
    rules.setBounds(20,90,700,350);                            // 12.
    rules.setFont(new Font("Tahoma", Font.PLAIN, 16));                // 13.
    rules.setText(                                                              // 14. rules gula set korar jnno setText function ta use krsi
    "<html>" +
        "1. Arrive at the exam hall at least 15 minutes before the exam starts.<br><br>" +
        "2. Mobile phones, smartwatches, and other electronic devices are strictly prohibited.<br><br>" +
        "3. Carry your admit card and student ID at all times.<br><br>" +
        "4. Any form of cheating or communication with others will result in disqualification.<br><br>" +
        "5. Do not talk or disturb others during the exam.<br><br>" +
        "6. Submit your answer script and any extra sheets before leaving.<br><br>" +
        "7. You are not allowed to leave the exam hall within the first 30 minutes.<br><br>" +
        "8. Use only authorized stationery. Borrowing is not allowed.<br><br>" +
    "</html>"
    );
    add(rules);                                                                             // 15.






    back = new JButton("Back");           // 16. JButton class theke akta button banabo back namer...etr bhitore ja likhbo ta button er upore likha ashbe
    back.setBounds(250,500,100, 30);           // 17.
    back.addActionListener(this);                          // 18. eta diye bujhae ei button ta te kono action hoise...mane ei button ta te click hoise
    add(back);                                             // 19.



    start = new JButton("Start");           // 20. JButton class theke arekta button banabo start namer...etr bhitore ja likhbo ta button er upore likha ashbe
    start.setBounds(400,500,100, 30);           // 21.
    start.addActionListener(this);                          // 22. eta diye bujhae ei button ta te kono action hoise...mane ei button ta te click hoise
    add(start);                                          // 23. 





        setSize(800,650);       // 4. frame tar size disi
        setLocation(350,100);            // 5. frame tar location set krsi
        setVisible(true);                   // 6. frame ta k visible kore disi
    }


    public void actionPerformed(ActionEvent ae) {                       //25.
        if(ae.getSource() == start) {                                   //26.

        }
        else if(ae.getSource() == back) {                               // 27.
           setVisible(false);                                         // 28.
           new Login();                                                 // 29.
        }
    }


    public static void main(String[] args) {
        new Rules("user");                                // 1. rules class er akta object banaisi...object banaile constructor call hbe
    }
}
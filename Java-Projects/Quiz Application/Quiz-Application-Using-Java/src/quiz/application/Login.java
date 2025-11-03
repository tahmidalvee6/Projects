package quiz.application;        // 1. package ta lage karon akta folder er modde arekta folder thakle taile dite hoy current file ta kon folder e ase
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;                  // 5. JFrame ta amdr thake swing package er modde....tai swing package ta import korte hoise




public class Login extends JFrame implements ActionListener{      // 4. Frame banaite amdr JFrame class ta extend krte hbe public void actionperformed(ActionEvent ae) er jnno...erpr JButton gula oikhan theke kati dite hbe


    JButton rules, back;            // 41. amdr ei 2 ta locally declare krte hbe a
    JTextField tfname;              // 47. eta k globally decalare krte hbe


    // 3. Login class er akta constructor banaitesi...amra chai jkhn amra class k run krbo jate frame dekha start hoye jae
    Login() {
        setLayout(null);           // 13. setLayout null diye eta bujhassi j ami swing er layout use korte chassi na...nijer layout banabo...eta korar por image ta chole jabe
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));     // 10. eikhane jframe er akta class banaisi ImageIcon...ei image ta k amdr frame er upore rakhte hbe
        JLabel image = new JLabel(i1);          // 12. tai amra direct na pass kore...JLabel er maddhome korte pari...eta korar por amdr image ta akdom maj borabor show krbe frame er... layout diye eta fixed kora jae....swings er layout frame k kothae boshbe bole dibe...amra chaile swing er layout use na kore nijer o use krte pari
 
        image.setBounds(0,0,600,500);         // 14. layout korar jnno amdr arekta funtion lagebe...eita 4 ta argument nibe...left theke 0 mane kono space nai...upor theke 0...length 600, width 500

        add(image);                        // 11. image ta frame er upore place korte amdr add function ta lagbe....add function er modde j image ba image k amra component dhori...oi component er obj ta pass krte hbe...kintu eta eikhane error dibe...karon amra direct pass krte parbo na


        JLabel heading = new JLabel("Here We Go !!!!");                 // 15. akhn frame er modde kisu lekhar jnno eta use krsi
        heading.setBounds(750,60,300,45);                   // 16. lekhata set korar jnno...left theke 750 theke start hbe...upor theke 60 theke start hbe... nijer length hbe 300...width 45
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));          // 18. eta diye lekhatar font ta change krtesi
        add(heading);                                                           // 17. trpr heading ta add kore dibo...add function cara kono kisu frame er add krte parbo na




        JLabel name = new JLabel("Enter Your Name");                 // 19. akhn frame er modde kisu lekhar jnno eta use krsi
        name.setBounds(810,150,300,20);                   // 20. lekhata set korar jnno...left theke 810 theke start hbe...upor theke 150 theke start hbe... nijer length hbe 300...width 20
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));          // 21. eta diye lekhatar font ta change krtesi
        add(name);                                                           // 22. trpr name ta add kore dibo...add function cara kono kisu frame er add krte parbo na


        tfname = new JTextField();                                       // 23. eikhane akta box create krsi JTextField diye jeikhan theke input nite parbo user theke
        tfname.setBounds(735,200,300,25);                           // 24.
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));         // 25.
        add(tfname);                                                                // 26.


        rules = new JButton("Rules");           // 27. JButton class theke akta button banabo rules namer...etr bhitore ja likhbo ta button er upore likha ashbe
        rules.setBounds(735,270,120, 25);           // 28.
        rules.addActionListener(this);                          // 39. eta diye bujhae ei button ta te kono action hoise...mane ei button ta te click hoise
        add(rules);                                                  // 29.


        back = new JButton("Back");           // 30. JButton class theke arekta button banabo back namer...etr bhitore ja likhbo ta button er upore likha ashbe
        back.setBounds(915,270,120, 25);           // 31.
        back.addActionListener(this);                          // 40. eta diye bujhae ei button ta te kono action hoise...mane ei button ta te click hoise
        add(back);                                         // 32.


        // 33. amdr akhn ei 2 ta button er upor click event lagaite hbe...jate rules e click korle arekta rules er frame e jate pare...r back e click korle jate akhn er frame ta off hoye jae
        // 34. akhn etr jnno amdr akta interface use korte hoy jeta holo Action Listener...jeta k amdr Login extends JFrame implement ActionListerner eivabe implement korte hbe ... eta k import krte hbe...awt.event.* theke
        // 36. kintu erpor o amdr akta error dibe login ta te...ActionListener j interface ta ase oikhane unimplement abstract method ase public void actionperformed(ActionEven ae)...
        // 37. ei jnno kono interface k implement krte oi interface er modde joto unimplement abstract method ase oigula re override krte hbe



        // 6. akhn amdr frame bananor jnno 2 ta function use korte hbe
        setSize(1200,500);     // 8. ei function ta diye amra akta size fixed kore disi...r eta by default top left e khulbe
        setLocation(200,200);           // 9. eta diye amra pura frame ta k center e niye ashsi... eikhane upor theke 200...left theke 200
        setVisible(true);               // 7. 1st j function ta hosse....amdr j frame ta by default hidden thake...tai frame ta setVisible true krte hoy jate amra frame ta k dkhte pari....eitutuk korar por amra run dile amra akta black window dkhte parbo... eikhane kintu size ta fixed thakbe na
    }

    //38. override
    public void actionPerformed(ActionEvent ae) {   // 38(override)
        if(ae.getSource() == rules) {               // 42. 
            String name = tfname.getText();             // 46. text field theke kono value neyar jnno..mane jodi Alvee input di oi text ta nibe..erpr Welcome Alvee type show krbe
            setVisible(false);
            new Rules(name);                                            // 45. akhn rules button e click krle amdr notun frame khulbe tw amdr notun frame banaite hbe...46.1 . erpr name ta k parameter akare nibo
        }
        else if(ae.getSource() == back){                // 43.
            setVisible(false);                          // 44. etr mane back e click korle current frame ta off hoye jabe
        }
    }

    





    public static void main(String[] args) {
        new Login();                            // 2. eikhane Login class er akta object banaisi
    }

}
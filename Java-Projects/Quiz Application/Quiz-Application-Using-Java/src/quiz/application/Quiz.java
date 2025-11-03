package quiz.application;

import javax.swing.*;                               // 5. JFrame er jnno import kore nisi

//package quizapplication;

public class Quiz extends JFrame{                     // 1. quiz name akta java class banaisi....4.1. trpr JFrame extends kore nisi karon amra frame banabo

    Quiz() {                                         // 4. akta constructor banailam
        setBounds(50,0,1440,850);                       // 6. Frame ta start hbe left theke 50 por...upor theke 0 mne top....trpr length 1440 r width disi 850
        setLayout(null);                                 // 8. setLayout null diye eta bujhassi j ami swing er layout use korte chassi na...nijer layout banabo

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));     //9.
        JLabel image = new JLabel(i1);                                                           // 10.
        image.setBounds(0,0,1440,392);                                          // 11.
        add(image);                                                                             // 12.


        setVisible(true);                                 // 7. etr mane holo amdr frame ta ready hoy
    }
    public static void main(String[] args) {            // 2. main method banailam
        new Quiz();                                     // 3. class er akta obj create krsi...obj bananor shthe shthe constructor call hoy..tai amdr constructor create krte hbe
    }
}
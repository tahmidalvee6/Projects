package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private StringBuilder currentInput;
    private double result = 0;
    private String operator = "=";
    private boolean calculating = true;

    public Calculator() {
        setSize(400, 500);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 32));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);

        currentInput = new StringBuilder();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            if (calculating) {
                currentInput.setLength(0);
                calculating = false;
            }
            currentInput.append(command);
            display.setText(currentInput.toString());
        } else if ("+-*/".contains(command)) {
            calculate(Double.parseDouble(display.getText()));
            operator = command;
            calculating = true;
        } else if (command.equals("=")) {
            calculate(Double.parseDouble(display.getText()));
            display.setText("" + result);
            operator = "=";
            calculating = true;
        } else if (command.equals("C")) {
            result = 0;
            currentInput.setLength(0);
            operator = "=";
            display.setText("0");
            calculating = true;
        }
    }

    private void calculate(double input) {
        switch (operator) {
            case "+": result += input; break;
            case "-": result -= input; break;
            case "*": result *= input; break;
            case "/": 
                if (input != 0) result /= input;
                else display.setText("Error");
                break;
            case "=": result = input; break;
        }
        display.setText("" + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class SimpleCalculator extends JFrame implements ActionListener 
{
    private JTextField display;
    private String operator;
    private double num1, num2, result;
    public SimpleCalculator() 
	{
        setTitle("Simple Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "%", "+", "="
        };

        for (String text : buttons) 
	{
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        setLayout(new BorderLayout(10, 10));
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9')
	{
            display.setText(display.getText() + command);
        } 
	else if (command.equals("=")) 
	{
            num2 = Double.parseDouble(display.getText());
            switch (operator) 
	    {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
            }
            display.setText(String.valueOf(result));
            operator = "";
        } else {
            // If the button is an operator, store the operator and the first operand
            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}

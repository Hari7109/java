import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapValues extends JFrame implements ActionListener {
    private JTextField textField1, textField2;
    private JButton swapButton;

    public SwapValues() {
        // Initialize GUI components
        setTitle("Swap Values");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Text fields
        textField1 = new JTextField();
        textField2 = new JTextField();
        swapButton = new JButton("Swap");

        // Add components to frame
        add(new JLabel("Textbox 1: "));
        add(textField1);
        add(new JLabel("Textbox 2: "));
        add(textField2);
        add(new JLabel(""));
        add(swapButton);

        // Add action listener
        swapButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Swap values of the text fields
        String temp = textField1.getText();
        textField1.setText(textField2.getText());
        textField2.setText(temp);
    }

    public static void main(String[] args) {
        new SwapValues();
    }
}

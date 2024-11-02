import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationCLI extends JFrame {
    private JTextField nameField, emailField;
    private JComboBox<String> seminarComboBox;

    public StudentRegistrationCLI() {
        // Initialize GUI components
        setTitle("Student Registration");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Name field
        add(new JLabel("Name: "));
        nameField = new JTextField();
        add(nameField);

        // Email field
        add(new JLabel("Email: "));
        emailField = new JTextField();
        add(emailField);

        // Seminar combo box
        add(new JLabel("Seminar: "));
        seminarComboBox = new JComboBox<>(new String[] { "Seminar 1", "Seminar 2", "Seminar 3" });
        add(seminarComboBox);

        // Register button
        JButton registerButton = new JButton("Register");
        add(registerButton);
        
        // Add action listener to the button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });

        setVisible(true);
    }

    private void registerStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        String seminar = (String) seminarComboBox.getSelectedItem();

        // Print details to the command line
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Seminar: " + seminar);
    }

    public static void main(String[] args) {
        new StudentRegistrationCLI();
    }
}

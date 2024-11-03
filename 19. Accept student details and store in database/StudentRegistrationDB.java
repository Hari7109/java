import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegistrationDB extends JFrame {
    private JTextField nameField, emailField, ageField;
    private JButton submitButton;

    public StudentRegistrationDB() {
        // Initialize GUI components
        setTitle("Student Registration");
        setSize(400, 300);
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

        // Age field
        add(new JLabel("Age: "));
        ageField = new JTextField();
        add(ageField);

        // Submit button
        submitButton = new JButton("Submit");
        add(submitButton);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });

        setVisible(true);
    }

    private void registerStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        int age = Integer.parseInt(ageField.getText());

        // Database connection
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students (name, email, age) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, age);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error registering student.");
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationDB();
    }
}

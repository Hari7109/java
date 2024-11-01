import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistration extends JFrame {
    private JTextField nameField, emailField;
    private JComboBox<String> seminarComboBox;
    private JTextArea displayArea;

    public StudentRegistration() {
        // Initialize GUI components
        setTitle("Student Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name: "));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email: "));
        emailField = new JTextField();
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Seminar: "));
        seminarComboBox = new JComboBox<>(new String[] {"Seminar 1", "Seminar 2", "Seminar 3"});
        inputPanel.add(seminarComboBox);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton registerButton = new JButton("Register");
        buttonPanel.add(registerButton);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        // Add action listener
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

        displayArea.append("Name: " + name + "\n");
        displayArea.append("Email: " + email + "\n");
        displayArea.append("Seminar: " + seminar + "\n\n");

        // Clear fields after registration
        nameField.setText("");
        emailField.setText("");
        seminarComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}

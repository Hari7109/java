import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EmployeeManagementApp extends JFrame {
    private JTextField nameField, ageField, deptField;
    private JTextArea displayArea;

    public EmployeeManagementApp() {
        // Initialize GUI components
        setTitle("Employee Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem addEmployee = new JMenuItem("Add Employee");
        JMenuItem viewEmployees = new JMenuItem("View Employees");
        menu.add(addEmployee);
        menu.add(viewEmployees);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name: "));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age: "));
        ageField = new JTextField();
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Department: "));
        deptField = new JTextField();
        inputPanel.add(deptField);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Set visibility of input panel initially to false
        inputPanel.setVisible(false);
        add(inputPanel, BorderLayout.NORTH);

        // Add action listeners
        addEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputPanel.setVisible(true);
            }
        });

        viewEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputPanel.setVisible(false);
                displayEmployees();
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEmployee();
                inputPanel.setVisible(false);
            }
        });
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addEmployee() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String department = deptField.getText();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO employees (name, age, department) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, department);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayEmployees() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            displayArea.setText("Employee Details:\n");
            while (rs.next()) {
                displayArea.append("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", Department: " + rs.getString("department") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EmployeeManagementApp();
    }
}

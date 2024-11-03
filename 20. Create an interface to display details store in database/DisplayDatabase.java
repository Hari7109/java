import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayDatabase extends JFrame {
    private JTextArea displayArea;
    private JButton loadButton;

    public DisplayDatabase() {
        // Initialize GUI components
        setTitle("Display Database");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Load Button
        loadButton = new JButton("Load Data");
        add(loadButton, BorderLayout.SOUTH);

        // Add action listener to the button
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

        setVisible(true);
    }

    private void loadData() {
        // Database connection
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // Clear previous data
            displayArea.setText("");

            // Display column headers
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                displayArea.append(rsmd.getColumnName(i) + "\t");
            }
            displayArea.append("\n");

            // Display data from database
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    displayArea.append(rs.getString(i) + "\t");
                }
                displayArea.append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data.");
        }
    }

    public static void main(String[] args) {
        new DisplayDatabase();
    }
}

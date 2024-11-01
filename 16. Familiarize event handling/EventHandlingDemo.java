import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandlingDemo extends JFrame {
    private JButton button;

    public EventHandlingDemo() {
        // Initialize GUI components
        setTitle("Event Handling Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create button and add action listener
        button = new JButton("Click Me!");
        button.addActionListener(new ButtonClickListener());

        // Add button to frame
        add(button);

        setVisible(true);
    }

    // Inner class to handle button click events
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Button was clicked!");
        }
    }

    public static void main(String[] args) {
        new EventHandlingDemo();
    }
}

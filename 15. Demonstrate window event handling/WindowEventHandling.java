import javax.swing.*;
import java.awt.event.*;

public class WindowEventHandling extends JFrame implements WindowListener {

    public WindowEventHandling() {
        // Initialize the frame
        setTitle("Window Event Handling Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Add window listener
        addWindowListener(this);

        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }   
    
    @Override
    public void windowClosing(WindowEvent e) {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            System.out.println("Window closing");
            dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window minimized");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window restored");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window deactivated");
    }

    public static void main(String[] args) {
        new WindowEventHandling();
    }
}

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Frame;

public class ShapeApplet extends Applet {

    public void paint(Graphics g) {
        // Draw a rectangle
        g.drawRect(20, 20, 100, 50);

        // Draw an oval
        g.drawOval(150, 20, 100, 50);

        // Draw a line
        g.drawLine(20, 100, 200, 100);

        // Draw a filled rectangle
        g.fillRect(20, 150, 100, 50);

        // Draw a filled oval
        g.fillOval(150, 150, 100, 50);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Shape Applet");
        ShapeApplet applet = new ShapeApplet();

        frame.add(applet);
        frame.setSize(400, 300);
        frame.setVisible(true);

        applet.init();
        applet.start();
    }
}

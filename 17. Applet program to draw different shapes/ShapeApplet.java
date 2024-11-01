import java.applet.Applet;
import java.awt.Graphics;

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
}

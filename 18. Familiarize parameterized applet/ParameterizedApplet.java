import java.applet.Applet;
import java.awt.Graphics;

public class ParameterizedApplet extends Applet {
    private int rectWidth;
    private int rectHeight;

    public void init() {
        // Simulate retrieving parameters
        rectWidth = getParameterValue("width", "200");
        rectHeight = getParameterValue("height", "100");
    }

    private int getParameterValue(String paramName, String defaultValue) {
        // Simulate getParameter logic
        return Integer.parseInt(defaultValue); // Here you can change the default value if needed
    }

    public void paint(Graphics g) {
        // Draw rectangle using parameters
        g.drawRect(20, 20, rectWidth, rectHeight);
    }
}

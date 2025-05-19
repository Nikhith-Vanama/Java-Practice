import java.applet.Applet;
import java.awt.Graphics;
class SimpleApplet extends Applet 
{
    public void init() 
    {
        System.out.println("Applet initialized");
    }

    // Start method
    public void start() 
    {
        System.out.println("Applet started");
    }

    // Stop method
    public void stop() {
        System.out.println("Applet stopped");
    }

    // Destroy method
    public void destroy() {
        System.out.println("Applet destroyed");
    }

    // Paint method
    public void paint(Graphics g) {
        g.drawString("Hello, Applet!", 20, 20);
    }
}

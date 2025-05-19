import java.applet.Applet;
import java.awt.*;
class AppletLifeCycleExample extends Applet {

    String message;

    public void init() {
        message = "Initializing Applet...";
        System.out.println("Init method called.");
    }

    public void start() {
        message = "Starting Applet...";
        System.out.println("Start method called.");
    }

    public void stop() {
        message = "Stopping Applet...";
        System.out.println("Stop method called.");
    }

    public void destroy() {
        message = "Destroying Applet...";
        System.out.println("Destroy method called.");
    }

    public void paint(Graphics g) {
        g.drawString(message, 20, 30);
    }
}

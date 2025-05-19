import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

class Slice {
    double value;
    Color color;

    public Slice(double value, Color color) {
        this.value = value;
        this.color = color;
    }
}

class MyComponent extends JComponent {
    Slice[] slices = {
        new Slice(25, Color.red),
        new Slice(33, Color.blue),
        new Slice(20, Color.green),
        new Slice(22, Color.yellow)
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPie((Graphics2D) g, getBounds(), slices);
    }

    void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;
        for (int i = 0; i < slices.length; i++) {
            total += slices[i].value;
        }

        double curValue = 0.0D;
        int startAngle = 0;
        for (int i = 0; i < slices.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slices[i].value * 360 / total);

            g.setColor(slices[i].color);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += slices[i].value;
        }
    }
}

class Pie {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyComponent());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
